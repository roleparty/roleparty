data class Sense(
    val label: String
) {

    companion object {
        private const val BLINDSIGHT = "Blindsight"
        private const val DARKVISION = "Darkvision"
        private const val TREMORSENSE = "Tremorsense"
        private const val TRUESIGHT = "Truesight"

        fun blindsight(distance: Distance) = Sense(BLINDSIGHT + "$distance")
        fun darkvision(distance: Distance) = Sense(DARKVISION + "$distance")
        fun tremorsense(distance: Distance) = Sense(TREMORSENSE + "$distance")
        fun truesight(distance: Distance) = Sense(TRUESIGHT + "$distance")
    }
}

typealias Senses = List<Sense>