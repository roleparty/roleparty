sealed class Skill(val modifier: Modifier)

// Strength
class Athletics(value: Int) : Skill(Modifier(value))

// Dexterity
class Acrobatics(value: Int) : Skill(Modifier(value))
class SleightOfHand(value: Int) : Skill(Modifier(value))
class Stealth(value: Int) : Skill(Modifier(value))

// Intelligence
class Arcana(value: Int) : Skill(Modifier(value))
class History(value: Int) : Skill(Modifier(value))
class Nature(value: Int) : Skill(Modifier(value))
class Religion(value: Int) : Skill(Modifier(value))

// Wisdom
class AnimalHandling(value: Int) : Skill(Modifier(value))
class Insight(value: Int) : Skill(Modifier(value))
class Medicine(value: Int) : Skill(Modifier(value))
class Perception(value: Int) : Skill(Modifier(value))
class Survival(value: Int) : Skill(Modifier(value))

// Charisma
class Deception(value: Int) : Skill(Modifier(value))
class Intimidation(value: Int) : Skill(Modifier(value))
class Performance(value: Int) : Skill(Modifier(value))
class Persuasion(value: Int) : Skill(Modifier(value))

data class SkillSet(
    val athletics: Athletics? = null,
    val acrobatics: Acrobatics? = null,
    val sleightOfHand: SleightOfHand? = null,
    val stealth: Stealth? = null,
    val arcana: Arcana? = null,
    val history: History? = null,
    val nature: Nature? = null,
    val religion: Religion? = null,
    val animalHandling: AnimalHandling? = null,
    val insight: Insight? = null,
    val medicine: Medicine? = null,
    val perception: Perception? = null,
    val survival: Survival? = null,
    val deception: Deception? = null,
    val intimidation: Intimidation? = null,
    val performance: Performance? = null,
    val persuasion: Persuasion? = null
) {
    val values = listOfNotNull(
        athletics,
        acrobatics,
        sleightOfHand,
        stealth,
        arcana,
        history,
        nature,
        religion,
        animalHandling,
        insight,
        medicine,
        perception,
        survival,
        deception,
        intimidation,
        performance,
        persuasion
    )

    override fun toString() = values.joinToString(", ") { "${it::class.simpleName!!.capitalizeWords()} ${it.modifier}" }
}