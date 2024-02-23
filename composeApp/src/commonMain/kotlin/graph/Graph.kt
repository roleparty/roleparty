package graph

import matrix.AdjacencyMatrix

open class Graph<V, E> {
    protected val vertices: MutableList<V> = mutableListOf()

    private val adjacencyMatrix: AdjacencyMatrix<E> = AdjacencyMatrix(vertices.size)

    val size get() = vertices.size

    fun addVertex(vertex: V): V {
        require(vertex !in vertices) { "Value `$vertex` already exist in this graph" }

        vertices += vertex
        adjacencyMatrix.addVertex()
        return vertex
    }

    fun removeVertex(value: V): V? {
        return vertexIndexOf(value)
            ?.let { index ->
                val deletedVertex = vertices.removeAt(index)
                // will remove the relations between this vertex and other vertices
                adjacencyMatrix.removeVertexAt(index)
                return deletedVertex
            }
    }

    fun setEdge(endpoints: Pair<V, V>, value: E?) {
        edgeIndexesOf(endpoints)
            ?.let { indexes ->
                adjacencyMatrix[indexes.first, indexes.second] = value
            }
    }

    fun getEdge(endpoints: Pair<V, V>): E? {
        return edgeIndexesOf(endpoints)
            ?.let { indexes ->
                return adjacencyMatrix[indexes.first, indexes.second]
            }
    }

    fun removeEdge(endpoints: Pair<V, V>): E? {
        return edgeIndexesOf(endpoints)
            ?.let { indexes ->
                val oldExistingEdge = adjacencyMatrix[indexes.first, indexes.second]
                adjacencyMatrix[indexes.first, indexes.second] = null
                return oldExistingEdge
            }
    }

    override fun toString(): String {
        val verticesAsString = vertices.joinToString(", ")
        val edgesAsString = adjacencyMatrix.toString()

        return """
        vertices = [$verticesAsString]
        edges = [$edgesAsString]
        """.trimIndent()
    }

    private fun vertexIndexOf(value: V): Int? {
        val index = vertices.indexOfFirst { it == value }
        return if (0 <= index) index else null
    }

    /**
     * Will return indexes of specified endpoints.
     * If at least one of two endpoints does not exist, will return null.
     */
    private fun edgeIndexesOf(endpoints: Pair<V, V>): Pair<Int, Int>? {
        var firstIndex: Int? = null
        var secondIndex: Int? = null
        var currentVertexIndex = 0

        /*
         * We don't want to browse vertices twice.
         * For that, we will iterate on list only one time and comparing the endpoints each time.
         */
        while (currentVertexIndex < size && (firstIndex == null || secondIndex == null)) {
            val vertex = vertices[currentVertexIndex]

            if (firstIndex == null && vertex == endpoints.first) {
                firstIndex = currentVertexIndex
            }

            if (secondIndex == null && vertex == endpoints.second) {
                secondIndex = currentVertexIndex
            }

            currentVertexIndex++
        }

        return if (firstIndex == null || secondIndex == null) null else Pair(firstIndex, secondIndex)
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        } else if (other is Graph<*, *>) {
            return other.vertices == vertices && adjacencyMatrix == adjacencyMatrix
        }

        return false
    }

    fun verticesSnapshot(): List<V> = vertices.toList()

    fun edgesSnapshot(): List<Edge<V, E>> = adjacencyMatrix
        .edges()
        .filter { it.value != null }
        .map { Edge(this.vertices[it.start], this.vertices[it.end], it.value!!) }


    override fun hashCode(): Int {
        var result = vertices.hashCode()
        result = 31 * result + adjacencyMatrix.hashCode()
        return result
    }

    data class Edge<V, E>(val start: V, val end: V, val value: E)
}