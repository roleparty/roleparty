import kotlin.jvm.JvmInline

data class Monster(
    val name: String,
    val type: String,
    val size: Size,
    val alignment: String,
    val armorClass: UInt,
    val hitPoints: HitPoints,
    val speeds: MovementSpeedSet,
    val abilities: AbilitySet,
    val skills: SkillSet,
    val savingThrows: SavingThrowSet,
    val senses: Senses,
    val languages: Languages,
    val challengeRating: ChallengeRating,
    val specialAbilities: List<SpecialAbility>,
    val actions: List<Action>,
    val legendaryActionsDescripion: String,
    val legendaryActions: List<Action>
)

data class HitPoints(
    val value: UInt,
    val dice: String
)


@JvmInline
value class Modifier(private val value: Int) {

    override fun toString() = if (value < 0) "$value" else "+$value"
}

