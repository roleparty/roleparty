package app.roleparty.tiyl

sealed interface Parents

data object UnknownParents : Parents {
    override fun toString() = "You do not know who your parents were."
}

data class KnownParents(
    val mother: Parent,
    val father: Parent
) : Parents {

    override fun toString(): String {
        return """
        You know who your parents are or were.

        Mother
        Name: ${mother.name}
        race: ${mother.race}
        Alignment: ${mother.alignment}
        Occupation: ${mother.occupation}
        Relationship: ${mother.relationship}
        
        Father
        Name: ${father.name}
        race: ${father.race}
        Alignment: ${father.alignment}
        Occupation: ${father.occupation}
        Relationship: ${father.relationship}
        """.trimIndent()
    }
}

data class Parent(
    val name: String,
    val alignment: String,
    val occupation: String,
    val relationship: String,
    val race: Race
) {
    enum class Race {
        HUMAN, DWARF, ELF, GNOME, HALF_ELF, HALFLING, HALF_ORC, TIEFLING, DEVIL, ORC, DRAGONBORN
    }
}