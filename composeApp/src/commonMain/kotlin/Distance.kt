data class Distance(
    val value: UInt,
    val unit: Unit
) {
    enum class Unit(
        val abbreviation: String
    ) {
        FEET("ft"),
        SQUARES("sq"),
        METERS("m")
    }

    override fun toString() = "$value ${unit.abbreviation}."
}