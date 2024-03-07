package app.roleparty.tiyl

import app.roleparty.tiyl.Gender.FEMALE
import app.roleparty.tiyl.Gender.MALE
import app.roleparty.tiyl.Race.DRAGONBORN
import app.roleparty.tiyl.Race.DWARF
import app.roleparty.tiyl.Race.ELF
import app.roleparty.tiyl.Race.GNOME
import app.roleparty.tiyl.Race.HALFLING
import app.roleparty.tiyl.Race.HALF_ELF
import app.roleparty.tiyl.Race.HALF_ORC
import app.roleparty.tiyl.Race.HUMAN
import app.roleparty.tiyl.Race.TIEFLING
import kotlin.random.Random

object Origins {

    fun randomParents(race: Race): Parents {
        val diceResult: UInt = (1u..100u).random()

        val parentRaces = randomNonHumanParents(race)

        return when (diceResult) {
            in 1u..95u -> if (Random.nextBoolean()) {
                KnownParents(
                    mother = randomParent(parentRaces.first, FEMALE),
                    father = randomParent(parentRaces.second, MALE)
                )
            } else {
                KnownParents(
                    mother = randomParent(parentRaces.second, FEMALE),
                    father = randomParent(parentRaces.first, MALE)
                )
            }

            else -> UnknownParents
        }
    }

    private fun randomParent(race: Parent.Race, gender: Gender) = Parent(
        name = when (gender) {
            MALE -> "Father"
            FEMALE -> "Mother"
        },
        alignment = SupplementalTables.randomAlignment(),
        occupation = SupplementalTables.randomOccupation(),
        relationship = SupplementalTables.randomRelationship(),
        race = race
    )

    fun randomSiblings(race: Race): Siblings {
        val numberOfSiblings = randomNumberOfSiblings(race)

        val siblings = List(numberOfSiblings) {
            Sibling(
                age = randomBirthOrder(),
                name = "Sibling",
                gender = Gender.entries.random(),
                race = race,
                alignment = SupplementalTables.randomAlignment(),
                occupation = SupplementalTables.randomOccupation(),
                relationShip = SupplementalTables.randomRelationship(),
                statut = SupplementalTables.randomStatut()
            )
        }

        return Siblings(siblings)
    }

    fun randomNonHumanParents(race: Race): Pair<Parent.Race, Parent.Race> {
        return when (race) {
            HALF_ELF -> randomHalfElfParents()
            HALF_ORC -> randomHalfOrcParents()
            TIEFLING -> randomTieflingParents()
            HUMAN -> Pair(Parent.Race.HUMAN, Parent.Race.HUMAN)
            DWARF -> Pair(Parent.Race.DWARF, Parent.Race.DWARF)
            ELF -> Pair(Parent.Race.ELF, Parent.Race.ELF)
            HALFLING -> Pair(Parent.Race.HALFLING, Parent.Race.HALFLING)
            DRAGONBORN -> Pair(Parent.Race.DRAGONBORN, Parent.Race.DRAGONBORN)
            GNOME -> Pair(Parent.Race.GNOME, Parent.Race.GNOME)
        }
    }

    fun randomBirthplace(): String {
        val diceResult: UInt = (1u..100u).random()

        return when (diceResult) {
            in 1u..50u -> "Home"
            in 51u..55u -> "Home of a family friend"
            in 56u..63u -> "Home of a healer or midwife"
            in 64u..65u -> "Carriage, cart, or wagon"
            in 66u..68u -> "Barn, shed, or other outbuilding"
            in 69u..70u -> "Cave"
            in 71u..72u -> "Field"
            in 73u..74u -> "Forest"
            in 75u..77u -> "Temple"
            78u -> "Battlefield"
            in 79u..80u -> "Alley or street"
            in 81u..82u -> "Brothel, tavern, or inn"
            in 83u..84u -> "Castle, keep, tower, or palace"
            85u -> "Sewer or rubbish heap"
            in 86u..88u -> "Among people of a different race"
            in 89u..91u -> "On board of boat or a ship"
            in 92u..93u -> "In a prison or in the headquarters of a secret organization"
            in 94u..95u -> "In a sage's laboratory"
            96u -> "In the Feywild"
            97u -> "In the Shadowfell"
            98u -> "On the Astral Plane or the Ethereal Plane"
            99u -> "On an Inner Plane of your choice"
            100u -> "On an Outer Place of your choice"
            else -> throw IllegalStateException("Can't be here")
        }
    }

    fun randomNumberOfSiblings(race: Race): Int {
        val diceResult: Int = (1..10).random()

        val siblingBase = when (diceResult) {
            in 1..2 -> 0
            in 3..4 -> (1..3).random()
            in 5..6 -> (1..4).random() + 1
            in 7..8 -> (1..6).random() + 2
            else -> (1..8).random() + 3
        }

        return when (race) {
            DWARF, ELF -> maxOf(siblingBase - 2, 0)
            HUMAN, HALFLING, DRAGONBORN, GNOME, HALF_ELF, HALF_ORC, TIEFLING -> siblingBase
        }
    }

    fun randomBirthOrder(): String {
        val diceResult: UInt = (1..2).sumOf { (1u..6u).random() }

        return when (diceResult) {
            2u -> "Twin, triplet or quadruplet"
            in 3u..7u -> "Older"
            in 8u..12u -> "Younger"
            else -> throw IllegalStateException("Can't be here")
        }
    }

    fun randomFamily(): String {
        val diceResult: UInt = (1u..100u).random()

        return when (diceResult) {
            1u -> "None"
            2u -> "Institution, such as an asylum"
            3u -> "Temple"
            in 4u..5u -> "Orphanage"
            in 6u..7u -> "Guardian"
            in 8u..15u -> "Paternal or maternal aunt, uncle, or both; or extended family such as a tribe or clan"
            in 16u..25u -> "Paternal or maternal grandparent(s)"
            in 26u..35u -> "Adoptive family (same or different race)"
            in 36u..55u -> "Single father or stepfather"
            in 56u..75u -> "Single mother or stepmother"
            in 70u..100u -> "Mother and father"
            else -> throw IllegalStateException("Can't be here")
        }
    }

    fun randomAbsentParent(): String {
        val diceResult: UInt = (1u..4u).random()

        return when (diceResult) {
            1u -> "Your parent died (${SupplementalTables.randomCauseOfDeath()})."
            2u -> "Your parent was emprisoned, enslaved, or otherwise taken away."
            3u -> "Your parent abandoned you."
            4u -> "Your parent disappeared to an unknown fate."
            else -> throw IllegalStateException("Can't be here")
        }
    }

    fun randomFamilyLifestyle(): String {
        val diceResult: UInt = (1..3).sumOf { (1u..6u).random() }

        return when (diceResult) {
            3u -> "Wretched"
            in 4u..5u -> "Squalid"
            in 6u..8u -> "Poor"
            in 9u..12u -> "Modest"
            in 13u..15u -> "Comfortable"
            in 16u..17u -> "Wealthy"
            18u -> "Aristocratic"
            else -> throw IllegalStateException("Can't be here")
        }
    }

    fun randomChildhoodHome(familyLifestyle: String): String {
        val diceResult: Int = (1..100).random()

        val diceResultWithFamilyLifestyleModifer = diceResult + familyLifestyleModifier(familyLifestyle)

        return when {
            diceResultWithFamilyLifestyleModifer <= 0 -> "On the streets"
            diceResultWithFamilyLifestyleModifer in 1..20 -> "Rundown shack"
            diceResultWithFamilyLifestyleModifer in 21..30 -> "No permanent residence; you moved around a lot"
            diceResultWithFamilyLifestyleModifer in 31..40 -> "Encampment or village in the wilderness"
            diceResultWithFamilyLifestyleModifer in 41..50 -> "Apartment in a rundown neighborhood"
            diceResultWithFamilyLifestyleModifer in 51..70 -> "Small house"
            diceResultWithFamilyLifestyleModifer in 71..90 -> "Large house"
            diceResultWithFamilyLifestyleModifer in 91..110 -> "Mansion"
            else -> "Palace or castle"
        }
    }

    fun randomChildhoodMemories(charismaModifier: Int): String {
        val diceResult = (1..3).sumOf { (1..6).random() }

        val diceResultWithCharismaModifier = diceResult + charismaModifier

        return when {
            diceResultWithCharismaModifier <= 3 -> "I am still haunted by my childhood, when I was treated badly by my peers."
            diceResultWithCharismaModifier in 4..5 -> "I spent most of my childhood alone, with no close friend."
            diceResultWithCharismaModifier in 6..8 -> "Others saw me as being different or strange, and so I had few companions."
            diceResultWithCharismaModifier in 9..12 -> "I had a few closed friends and lived an ordinary childhood."
            diceResultWithCharismaModifier in 13..15 -> "I had several friends, and my childhood was generally a happy one."
            diceResultWithCharismaModifier in 16..17 -> "I always found it easy to make friends, and I loved being around people."
            else -> "Everyone knew who I was, and I had friends everywhere I went."
        }
    }

    private fun familyLifestyleModifier(familyLifestyle: String): Int {
        return when (familyLifestyle) {
            "Wretched" -> -40
            "Squalid" -> -20
            "Poor" -> -10
            "Modest" -> 0
            "Comfortable" -> 10
            "Wealthy" -> 20
            "Aristocratic" -> 40
            else -> throw IllegalStateException("Can't be here")
        }
    }

    private fun randomHalfElfParents(): Pair<Parent.Race, Parent.Race> {
        val diceResult: Int = (1..8).random()

        return when (diceResult) {
            in 1..5 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.ELF, Parent.Race.HUMAN)
            } else {
                Pair(Parent.Race.HUMAN, Parent.Race.ELF)
            }

            6 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.ELF, Parent.Race.HALF_ELF)
            } else {
                Pair(Parent.Race.HALF_ELF, Parent.Race.ELF)
            }

            7 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.HUMAN, Parent.Race.HALF_ELF)
            } else {
                Pair(Parent.Race.HALF_ELF, Parent.Race.HUMAN)
            }

            else -> Pair(Parent.Race.HALF_ELF, Parent.Race.HALF_ELF)
        }
    }

    private fun randomHalfOrcParents(): Pair<Parent.Race, Parent.Race> {
        val diceResult: Int = (1..8).random()

        return when (diceResult) {
            in 1..3 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.ORC, Parent.Race.HUMAN)
            } else {
                Pair(Parent.Race.HUMAN, Parent.Race.ORC)
            }

            in 4..5 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.ORC, Parent.Race.HALF_ORC)
            } else {
                Pair(Parent.Race.HALF_ORC, Parent.Race.ORC)
            }

            in 6..7 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.HUMAN, Parent.Race.HALF_ORC)
            } else {
                Pair(Parent.Race.HALF_ORC, Parent.Race.HUMAN)
            }

            else -> Pair(Parent.Race.HALF_ORC, Parent.Race.HALF_ORC)
        }
    }

    private fun randomTieflingParents(): Pair<Parent.Race, Parent.Race> {
        val diceResult: Int = (1..8).random()

        return when (diceResult) {
            in 1..4 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.HUMAN, Parent.Race.HUMAN)
            } else {
                Pair(Parent.Race.HUMAN, Parent.Race.HUMAN)
            }

            in 5..6 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.HUMAN, Parent.Race.TIEFLING)
            } else {
                Pair(Parent.Race.TIEFLING, Parent.Race.HUMAN)
            }

            7 -> if (Random.nextBoolean()) {
                Pair(Parent.Race.DEVIL, Parent.Race.TIEFLING)
            } else {
                Pair(Parent.Race.TIEFLING, Parent.Race.DEVIL)
            }

            else -> if (Random.nextBoolean()) {
                Pair(Parent.Race.DEVIL, Parent.Race.HUMAN)
            } else {
                Pair(Parent.Race.HUMAN, Parent.Race.DEVIL)
            }
        }
    }

    enum class SiblingRace {
        ELF,
        DWARF,
        OTHER
    }
}