data class ChallengeRating(
    val challenge: UInt,
    val experience: UInt
) {

    override fun toString() = "$challenge ($experience XP)"
}