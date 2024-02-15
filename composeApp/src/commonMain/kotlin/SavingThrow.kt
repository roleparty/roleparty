data class SavingThrow(
    val modifier: Modifier,
    val ability: Ability.Type
)

class SavingThrowSet private constructor(
    val strength: SavingThrow?,
    val dexterity: SavingThrow?,
    val constitution: SavingThrow?,
    val intelligence: SavingThrow?,
    val wisdom: SavingThrow?,
    val charisma: SavingThrow?
) {
    val values = listOfNotNull(strength, dexterity, constitution, intelligence, wisdom, charisma)
    
    constructor(
        strength: Int = 0,
        dexterity: Int = 0,
        constitution: Int = 0,
        intelligence: Int = 0,
        wisdom: Int = 0,
        charisma: Int = 0,
    ) : this(
        strength = if (strength != 0) SavingThrow(Modifier(strength), Ability.Type.STRENGTH) else null,
        dexterity = if (dexterity != 0) SavingThrow(Modifier(dexterity), Ability.Type.DEXTERITY) else null,
        constitution = if (constitution != 0) SavingThrow(Modifier(constitution), Ability.Type.CONSTITUTION) else null,
        intelligence = if (intelligence != 0) SavingThrow(Modifier(intelligence), Ability.Type.INTELLIGENCE) else null,
        wisdom = if (wisdom != 0) SavingThrow(Modifier(wisdom), Ability.Type.WISDOM) else null,
        charisma = if (charisma != 0) SavingThrow(Modifier(charisma), Ability.Type.CHARISMA) else null,
    )
}