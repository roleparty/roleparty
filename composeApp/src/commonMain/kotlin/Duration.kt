data class Duration(
    val value: UInt,
    val unit: Unit
) {
    enum class Unit {
        ROUND
    }
}