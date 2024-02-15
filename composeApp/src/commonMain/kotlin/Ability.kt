class Ability private constructor(val value: UInt, val type: Type) {
    val modifier = Modifier(value.toInt() / 2 - 5)

    enum class Type {
        STRENGTH,
        DEXTERITY,
        CONSTITUTION,
        INTELLIGENCE,
        WISDOM,
        CHARISMA;

        val abbreviation: String = name.substring(0..2)
    }

    companion object {
        fun strength(value: UInt) = Ability(value, Type.STRENGTH)
        fun dexterity(value: UInt) = Ability(value, Type.DEXTERITY)
        fun constitution(value: UInt) = Ability(value, Type.CONSTITUTION)
        fun intelligence(value: UInt) = Ability(value, Type.INTELLIGENCE)
        fun wisdom(value: UInt) = Ability(value, Type.WISDOM)
        fun charisma(value: UInt) = Ability(value, Type.CHARISMA)
    }
}

class AbilitySet private constructor(
    strength: Ability,
    dexterity: Ability,
    constitution: Ability,
    intelligence: Ability,
    wisdom: Ability,
    charisma: Ability,
) {
    private val values = listOf(strength, dexterity, constitution, intelligence, wisdom, charisma)

    constructor(
        strength: UInt,
        dexterity: UInt,
        constitution: UInt,
        intelligence: UInt,
        wisdom: UInt,
        charisma: UInt
    ) : this(
        Ability.strength(strength),
        Ability.dexterity(dexterity),
        Ability.constitution(constitution),
        Ability.intelligence(intelligence),
        Ability.wisdom(wisdom),
        Ability.charisma(charisma)
    )

    fun toList() = values
}