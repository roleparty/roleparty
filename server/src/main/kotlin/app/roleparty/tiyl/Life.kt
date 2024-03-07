package app.roleparty.tiyl

data class Life(
    val race: Race,
    val parents: Parents,
    val birthplace: String,
    val siblings: Siblings,
    val personalDecisions: PersonalDecisions,
) {

    override fun toString(): String {
        return """
            _ Race _
            $race
            
            _ Parents _
            $parents
                
            _ Birthplace _
            $birthplace
                
            _ Siblings _
            $siblings
            
            _ Personal Decisions _
            $personalDecisions
        """.trimIndent().replace("            ", "")
    }

    companion object {

        fun random(): Life {
            val race = Race.entries.random()
            return Life(
                race = race,
                parents = Origins.randomParents(race),
                birthplace = Origins.randomBirthplace(),
                siblings = Origins.randomSiblings(race),
                personalDecisions = PersonalDecisions.random()
            )
        }
    }
}