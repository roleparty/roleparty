import kotlin.jvm.JvmInline

data class Monster(
    val name: String,
    val type: String,
    val size: Size,
    val alignement: String,
    val armorClass: UInt,
    val hitPoints: HitPoints,
    val speeds: List<Speed>
)

data class HitPoints(
    val value: UInt,
    val dice: String
)

data class Speed(
    val type: Type,
    val value: UInt,
    val unit: Unit
) {
    
    enum class Type {
        WALK,
        SWIM
    }
    
    enum class Unit {
        FEET,
        SQUARES,
        METERS
    }
}

sealed class Ability(val value: UInt) {
    
    class Strength()
}