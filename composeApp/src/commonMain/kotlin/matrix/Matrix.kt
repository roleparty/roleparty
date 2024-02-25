package matrix

interface Matrix<T> {

    val rows: Int
    val cols: Int

    val dimension: Int get() = rows * cols

    /**
     * Return the element found at specified position
     */
    operator fun get(row: Int, col: Int): T?
}