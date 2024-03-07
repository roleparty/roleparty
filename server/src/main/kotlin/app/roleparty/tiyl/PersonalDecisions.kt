package app.roleparty.tiyl

import PersonalDecisionTables.Background.randomAcolyte
import PersonalDecisionTables.Background.randomCharlatan
import PersonalDecisionTables.Background.randomCriminal
import PersonalDecisionTables.Background.randomEntertainer
import PersonalDecisionTables.Background.randomFolkHero
import PersonalDecisionTables.Background.randomGuildArtisan
import PersonalDecisionTables.Background.randomHermit
import PersonalDecisionTables.Background.randomNoble
import PersonalDecisionTables.Background.randomOutlander
import PersonalDecisionTables.Background.randomSage
import PersonalDecisionTables.Background.randomSailor
import PersonalDecisionTables.Background.randomSoldier
import PersonalDecisionTables.Background.randomUrchin

data class PersonalDecisions(
    val background: Background,
    val reason: String,
) {

    companion object {

        fun random(): PersonalDecisions {
            val background = Background.entries.random()
            val reason = when (background) {
                Background.ACOLYTE -> randomAcolyte()
                Background.CHARLATAN -> randomCharlatan()
                Background.CRIMINAL -> randomCriminal()
                Background.ENTERTAINER -> randomEntertainer()
                Background.FOLK_HERO -> randomFolkHero()
                Background.GUILD_ARTISAN -> randomGuildArtisan()
                Background.HERMIT -> randomHermit()
                Background.NOBLE -> randomNoble()
                Background.OUTLANDER -> randomOutlander()
                Background.SAGE -> randomSage()
                Background.SAILOR -> randomSailor()
                Background.SOLDIER -> randomSoldier()
                Background.URCHIN -> randomUrchin()
            }

            return PersonalDecisions(background = background, reason = reason)
        }
    }

    override fun toString(): String {
        val lowercaseBackground = background.name.lowercase().replace("_", " ")
        return """
            Background: ${lowercaseBackground.replaceFirstChar { it.uppercase() }}
            I became a $lowercaseBackground because: $reason
        """.trimIndent()
    }
}
