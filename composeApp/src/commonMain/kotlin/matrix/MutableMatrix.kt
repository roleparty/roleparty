package matrix

interface MutableMatrix<T> : Matrix<T> {
    
    /**
     * Set value at specified position and return the old value
     */
    operator fun set(row: Int, col: Int, value: T?)
}