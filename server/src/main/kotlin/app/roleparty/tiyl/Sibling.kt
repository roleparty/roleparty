package app.roleparty.tiyl

@JvmInline
value class Siblings(val value: List<Sibling>) {
    override fun toString(): String {
        return if (value.isEmpty()) {
            "You are an only child."
        } else {
            value.joinToString("\n\n") { it.toString() }
        }
    }
}

data class Sibling(
    val age: String,
    val name: String,
    val gender: Gender,
    val race: Race,
    val alignment: String,
    val occupation: String,
    val relationShip: String,
    val statut: String
) {
    override fun toString(): String {
        return """
        age: $age
        name: $name
        gender: $gender
        race: $race
        alignment: $alignment
        occupation: $occupation
        relationship: $relationShip
        statut: $statut
        """.trimIndent()
    }
}