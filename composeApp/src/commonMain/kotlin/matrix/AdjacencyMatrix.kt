package matrix

/**
 * In graph theory and computer science,
 * an adjacency matrix is a square matrix
 * used to represent a finite graph.
 *
 * Example :
 *
 * ```
 * |   | A | B | C |
 * | A |   | * |   |
 * | B |   |   |   |
 * | C | * |   | * |
 * ```
 *
 * will be translated to
 *
 * ```
 * A -> B
 * C -> A
 * C -> C
 * ```
 */
class AdjacencyMatrix<T>(initialNumberOfVertices: Int) : MutableMatrix<T>, SquareMatrix<T> {

    private val entries = MutableList(initialNumberOfVertices) { MutableList<T?>(initialNumberOfVertices) { null } }

    override val order get() = entries.size

    val vertices get() = entries.size

    init {
        require(0 <= initialNumberOfVertices) { "The number of vertices must be at least equals to 0" }
    }

    override fun set(row: Int, col: Int, value: T?) {
        entries[row][col] = value
    }

    override fun get(row: Int, col: Int) = entries[row][col]

    fun addVertex() {
        entries.add(MutableList(order) { null })
        entries.forEach { row -> row.add(null) }
    }

    fun removeVertexAt(index: Int) {
        entries.forEach { row -> row.removeAt(index) }
        entries.removeAt(index)
    }

    fun edges(): List<Edge<T?>> {
        return entries.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, edge ->
                Edge(
                    rowIndex,
                    colIndex,
                    edge
                )
            }
        }.flatten()
    }

    override fun toString(): String {
        return "[${entries.joinToString { row -> "[${row.joinToString()}]" }}]"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        } else if (other is AdjacencyMatrix<*>) {
            for (row in entries.indices) {
                for (col in entries[row].indices) {
                    if (other.entries[row][col] != entries[row][col]) {
                        return false
                    }
                }
            }
            return true
        }

        return false
    }

    data class Edge<T>(
        val start: Int,
        val end: Int,
        val value: T
    )
}