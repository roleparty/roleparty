//package graph
//
//import matrix.Mutable2DArrayMatrix
//import matrix.MutableMatrix
//
//class AdjacencyMatrix<T> private constructor(private val vertices: UInt = 0u, private val edges: MutableList<T?>) :
//    MutableMatrix<T> by Mutable2DArrayMatrix(vertices, vertices, edges) {
//
//    constructor(
//        vertices: UInt = 0u,
//        init: (row: UInt, col: UInt) -> T? = { _, _ -> null }
//    ) : this(
//        vertices,
//        MutableList((vertices * vertices).toInt()) { index ->
//            init(
//                index.toUInt() / vertices,
//                index.toUInt() % vertices
//            )
//        }
//    )
//    
//    fun addVertex() {
//        val indexAsInt = index.toInt()
//        val colsAsInt = cols.toInt()
//        val newEdges = edges.toMutableList()
//
//        // add 'c'
//        // ['aa', 'ab', 'ba', 'bb']
//        newEdges.addAll((colsAsInt * indexAsInt), MutableList(colsAsInt) { null })
//        // ['aa', 'ab', 'ad', 'ba', 'bb', 'bd', 'ca', 'cb', 'cd', 'da', 'db', 'dd']
//
//        val highestEdgeIndexToAdd = ((cols + 1u) * rows - (cols - index))
//        val edgeIndexes = if (colsAsInt != 0) highestEdgeIndexToAdd downTo 0u step colsAsInt else highestEdgeIndexToAdd downTo 0u
//        for (edgeIndex in edgeIndexes) {
//            newEdges.add(edgeIndex.toInt(), null)
//        }
//        // ['aa', 'ab', 'ac', 'ad', 'ba', 'bc', 'bb', 'bd', 'ca', 'cb', 'cc', 'cd', 'da', 'db', 'dc', 'dd']
//
//        return AdjacencyMatrix(colsAsInt.toUInt(), newEdges)
//    }
//
//    fun removeVertexAt(index: UInt): AdjacencyMatrix<T> {
//
//        val indexAsInt = index.toInt()
//        val numberOfVertices = vertices.toInt()
//
//        // TODO: find a boolean condition based on indexes to remove vertex relative edges with only one filter
//        val filteredEdges = edges
//            // remove 'c'
//            // ['aa', 'ab', 'ac', 'ad', 'ba', 'bb', 'bc', 'bd', 'ca', 'cb', 'cc', 'cd', 'da', 'db', 'dc', 'dd']
//            .filterIndexed { edgeIndex, _ -> edgeIndex % numberOfVertices != indexAsInt } // remove all 'c' as destination
//            // ['aa', 'ab', 'ad', 'ba', 'bb', 'bd', 'ca', 'cb', 'cd', 'da', 'db', 'dd']
//            .filterIndexed { edgeIndex, _ -> edgeIndex / (indexAsInt * (numberOfVertices - 1)) != 1 } // remove all 'c' as starting point
//            // ['aa', 'ab', 'ad', 'ba', 'bb', 'bd', 'da', 'db', 'dd']
//            .toMutableList()
//
//        return AdjacencyMatrix(vertices - 1u, filteredEdges)
//    }
//
//    override fun toString() = edges.joinToString()
//}