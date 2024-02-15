import Distance.Unit.FEET
import Duration.Unit.ROUND
import MovementType.SWIM
import MovementType.WALK

data class Speed(
    val distance: Distance,
    val duration: Duration
)

enum class MovementType {
    WALK,
    SWIM
}

data class MovementSpeed(
    val speed: Speed,
    val movementType: MovementType
)

class MovementSpeedSet private constructor(
    val walk: MovementSpeed?,
    val swim: MovementSpeed?
) {
    val values = listOfNotNull(walk, swim)
    
    constructor(
        walk: UInt,
        swim: UInt
    ) : this(
        walk = if (walk > 0u) MovementSpeed(Speed(Distance(walk, FEET), Duration(1u, ROUND)), WALK) else null,
        swim = if (swim > 0u) MovementSpeed(Speed(Distance(swim, FEET), Duration(1u, ROUND)), SWIM) else null
    )
}