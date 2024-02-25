package matrix

interface SquareMatrix<T> : Matrix<T> {

    val order: Int

    override val rows get() = order
    override val cols get() = order
}