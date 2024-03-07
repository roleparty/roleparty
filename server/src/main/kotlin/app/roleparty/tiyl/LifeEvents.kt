package app.roleparty.tiyl

object LifeEvents {

    fun randomNumberOfLifeEvents(age: UInt): Pair<String, UInt> {
        val diceResult = (1..100).random()

        return when (diceResult) {
            in 1..20 -> Pair("20 years or younger", 1u)
            in 21..59 -> Pair("21-30 years", (1u..4u).random())
            in 60..69 -> Pair("31-40 years", (1u..6u).random())
            in 70..89 -> Pair("41-50 years", (1u..8u).random())
            in 90..99 -> Pair("51-60 years", (1u..10u).random())
            else -> Pair("61 years or older", (1u..12u).random())
        }
    }

    fun randomLifeEvent(): String {
        val diceResult = (1..100).random()

        return when (diceResult) {
            in 1..10 -> "You suffered a tragedy. Roll on the Tragedies table."
            in 11..20 -> "You gained a bit of good fortune. Roll on the Boons table."
            in 21..30 -> "You fell in love or got married. If you get this result more than once, you can choose to have a child instead. Work with your DM to determine the identity of your love interest."
            in 31..40 -> "You made an enemy of an adventurer. Roll a d6. An odd number indicates you are to blame for the rift, and an even number indicates you are blameless. Use the supplemental tables and work with your DM to determine this hostile character's identity and the danger this enemy poses to you."
            in 41..50 -> "You made a friend of an adventurer. Use the supplemental tables and work with your DM to add more detail to this friendly character and establish how your friendship began."
            in 51..70 -> "You spent time working in a job related to your background. Start the game with an extra 2d6 gp."
            in 71..75 -> "You met someone important. Use the supplemental tables to determine this character's identity and how this individual feels about you. Work out additional details with your DM as needed to fit this character into your backstory."
            in 76..80 -> "You went on an adventure. Roll on the Adventures table to see what happened to you. Work with your DM to determine the nature of the adventure and the creatures you encountered."
            in 81..85 -> "You had a supernatural experience. Roll on the Supernatural Events table to find out what it was."
            in 86..90 -> "You fought in a battle. Roll on the War table to learn what happened to you. Work with your DM to come up with the reason for the battle and the factions involved. It might have been a small conflict between your community and a band of ores, or it could have been a major battle in a larger war."
            in 91..95 -> "You committed a crime or were wrongly accused of doing so. Roll on the Crime table to determine the nature of the offense and on the Punishment table to see what became of you."
            in 96..99 -> "You encountered something magical. Roll on the Arcane Matters table."
            else -> "Something truly strange happened to you. Roll on the Weird Stuff table."
        }
    }

    object SecondaryTables {

        fun randomAdventure(): String {
            val diceResult = (1..100).random()

            return when (diceResult) {
                in 1..10 -> "You nearly died. You have nasty scars on your body, and you are missing an ear, 1d3 fingers, or 1d4 toes."
                in 11..20 -> "You suffered a grievous injury. Although the wound healed, it still pains you from time to time."
                in 21..30 -> "You were wounded, but in time you fully recovered."
                in 31..40 -> "You contracted a disease while exploring a filthy warren. You recovered from the disease, but you have a persistent cough, pockmarks on your skin, or prematurely gray hair."
                in 41..50 -> "You were poisoned by a trap or a monster. You recovered, but the next time you make a saving throw against poison, you make the saving throw with disadvantage."
                in 51..60 -> "You lost something of sentimental value to you during your adventure. Remove one trinket from your possessions."
                in 61..70 -> "You were terribly frightened by something you encountered and ran away, abandoning your companions to their fate."
                in 71..80 -> "You learned a great deal during your adventure. The next time you make an ability check or a saving throw, you have advantage on the roll."
                in 81..90 -> "You found some treasure on your adventure. You have 2d6 gp left from your share of it."
                in 91..99 -> "You found a considerable amount of treasure on your adventure. You have 1d20 + 50 gp left from your share of it."
                else -> "You came across a common magic item (of the DM’s choice)."
            }
        }

        fun randomArcaneMatters(): String {
            val diceResult = (1..10).random()

            return when (diceResult) {
                1 -> "You were charmed or frightened by a spell."
                2 -> "You were injured by the effect of a spell."
                3 -> "You witnessed a powerful spell being cast by a cleric, a druid, a sorcerer, a warlock, or a wizard."
                4 -> "You drank a potion (of the DM’s choice)."
                5 -> "You found a Spell Scroll (of the DM’s choice) and succeeded in casting the spell it contained."
                6 -> "You were affected by teleportation magic."
                7 -> "You turned invisible for a time."
                8 -> "You identified an illusion for what it was."
                9 -> "You saw a creature being conjured by magic."
                else -> "Your fortune was read by a diviner. Roll twice on the Life Events table, but don’t apply the results. Instead, the DM picks one event as a portent of your future (which might or might not come true)."
            }
        }

        fun randomBoons(): String {
            val diceResult = (1..10).random()

            return when (diceResult) {
                1 -> "A friendly wizard gave you a Spell Scroll containing one cantrip (of the DM’s choice)."
                2 -> "You saved the life of a commoner, who now owes you a life debt. This individual accompanies you on your travels and performs mundane tasks for you, but will leave if neglected, abused, or imperiled. Determine details about this character by using the supplemental tables and working with your DM."
                3 -> "You found a riding horse."
                4 -> "You found some money. You have 1d20 gp in addition to your regular starting funds."
                5 -> "A relative bequeathed you a simple weapon of your choice."
                6 -> "You found something interesting. You gain one additional trinket."
                7 -> "You once performed a service for a local temple. The next time you visit the temple, you can receive healing up to your hit point maximum."
                8 -> "A friendly alchemist gifted you with a Potion of Healing or a flask of acid, as you choose."
                9 -> "You found a treasure map."
                else -> "A distant relative left you a stipend that enables you to live at the comfortable lifestyle for 1d20 years. If you choose to live at a higher lifestyle, you reduce the price of the lifestyle by 2 gp during that time period."
            }
        }

        fun randomCrime(): String {
            val diceResult = (1..8).random()

            return when (diceResult) {
                1 -> "Murder"
                2 -> "Theft"
                3 -> "Burglary"
                4 -> "Assault"
                5 -> "Smuggling"
                6 -> "Kidnapping"
                7 -> "Extortion"
                else -> "Counterfeiting"
            }
        }

        fun randomPunishment(): String {
            val diceResult = (1..12).random()

            return when (diceResult) {
                in 1..3 -> "You did not commit the crime and were exonerated after being accused."
                in 4..6 -> "You committed the crime or helped do so, but nonetheless the authorities found you not guilty."
                in 7..8 -> "You were nearly caught in the act. You had to flee and are wanted in the community where the crime occurred."
                else -> "You were caught and convicted. You spent time in jail, chained to an oar, or performing hard labor. You served a sentence of 1d4 years or succeeded in escaping after that much time."
            }
        }

        fun randomSupernaturalEvent(): String {
            val diceResult = (1..100).random()

            return when (diceResult) {
                in 1..5 -> "You were ensorcelled by a fey and enslaved for 1d6 years before you escaped."
                in 6..10 -> "You saw a demon and ran away before it could do anything to you."
                in 11..15 -> "A devil tempted you. Make a DC 10 Wisdom saving throw. On a failed save, your alignment shifts one step towards evil (if it’s not evil already), and you start the game with an additional 1d20 + 50 gp."
                in 16..20 -> "You woke up one morning miles from your home, with no idea how you got there."
                in 21..30 -> "You visited a holy site and felt the presence of the divine there."
                in 31..40 -> "You witnessed a falling red star, a face appearing in the frost, or some other bizarre happening. You are certain that it was an omen of some sort."
                in 41..50 -> "You escaped certain death and believe it was the intervention of a god that saved you."
                in 51..60 -> "You witnessed a minor miracle."
                in 61..70 -> "You explored an empty house and found it to be haunted."
                in 71..75 -> "You were briefly possessed. Roll a d6 to determine what type of creature possessed you: 1, celestial; 2, devil; 3, demon; 4, fey; 5, elemental; 6, undead."
                in 76..80 -> "You saw a ghost."
                in 81..85 -> "You saw a ghoul feeding on a corpse."
                in 86..90 -> "A celestial or a fiend visited you in your dreams to give a warning of dangers to come."
                in 91..95 -> "You briefly visited the Feywild or the Shadowfell."
                else -> "You saw a portal that you believe leads to another plane of existence."
            }
        }

        fun randomTragedy(): String {
            val diceResult = (1..12).random()

            return when (diceResult) {
                in 1..2 -> "A family member or a close friend died. Roll on the Cause of Death supplemental table to find out how."
                3 -> "A friendship ended bitterly, and the other person is now hostile to you. The cause might have been a misunderstanding or something you or the former friend did."
                4 -> "You lost all your possessions in a disaster, and you had to rebuild your life."
                5 -> "You were imprisoned for a crime you didn't commit and spent 1d6 years at hard labor, in jail, or shackled to an oar in a slave galley."
                6 -> "War ravaged your home community, reducing everything to rubble and ruin. In the aftermath, you either helped your town rebuild or moved somewhere else."
                7 -> "A lover disappeared without a trace. You have been looking for that person ever since."
                8 -> "A terrible blight in your home community caused crops to fail, and many starved. You lost a sibling or some other family member."
                9 -> "You did something that brought terrible shame to you in the eyes of your family. You might have been involved in a scandal, dabbled in dark magic, or offended someone important. The attitude of your family members toward you becomes indifferent at best, though they might eventually forgive you."
                10 -> "For a reason you were never told, you were exiled from your community. You then either wandered in the wilderness for a time or promptly found a new place to live."
                11 -> "A romantic relationship ended. Roll a d6. An odd number means it ended with bad feelings, while an even number means it ended amicably."
                else -> "A current or prospective romantic partner of yours died. Roll on the Cause of Death supplemental table to find out how. If the result is murder, roll a d12. On a 1, you were responsible, whether directly or indirectly."
            }
        }

        fun randomWar(): String {
            val diceResult = (1..12).random()

            return when (diceResult) {
                1 -> "You were knocked out and left for dead. You woke up hours later with no recollection of the battle."
                in 2..3 -> "You were badly injured in the fight, and you still bear the awful scars of those wounds."
                4 -> "You ran away from the battle to save your life, but you still feel shame for your cowardice."
                in 5..7 -> "You suffered only minor injuries, and the wounds all healed without leaving scars."
                in 8..9 -> "You survived the battle, but you suffer from terrible nightmares in which you relive the experience."
                in 10..11 -> "You escaped the battle unscathed, though many of your friends were injured or lost."
                else -> "You acquitted yourself well in battle and are remembered as a hero. You might have received a medal for your bravery."
            }
        }

        fun randomWeirdStuff(): String {
            val diceResult = (1..12).random()

            return when (diceResult) {
                1 -> "You were turned into a toad and remained in that form for 1d4 weeks."
                2 -> "You were petrified and remained a stone statue for a time until someone freed you."
                3 -> "You were enslaved by a hag, a satyr, or some other being and lived in that creature's thrall for 1d6 years."
                4 -> "A dragon held you as a prisoner for 1d4 months until adventurers killed it."
                5 -> "You were taken captive by a race of evil humanoids such as drow, kuo-toa, or quaggoths. You lived as a slave in the Underdark until you escaped."
                6 -> "You served a powerful adventurer as a hireling. You have only recently left that service. Use the supplemental tables and work with your DM to determine the basic details about your former employer."
                7 -> "You went insane for 1d6 years and recently regained your sanity. A tic or some other bit of odd behavior might linger."
                8 -> "A lover of yours was secretly a silver dragon."
                9 -> "You were captured by a cult and nearly sacrificed on an altar to the foul being the cultists served. You escaped, but you fear they will find you."
                10 -> "You met a demigod, an archdevil, an archfey, a demon lord, or a titan, and you lived to tell the tale."
                11 -> "You were swallowed by a giant fish and spent a month in its gullet before you escaped."
                else -> "A powerful being granted you a Wish, but you squandered it on something frivolous."
            }
        }
    }
}