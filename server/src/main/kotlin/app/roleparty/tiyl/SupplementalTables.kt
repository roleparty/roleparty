package app.roleparty.tiyl

import kotlin.random.Random

object SupplementalTables {

    fun randomAlignment(): String {
        val diceResult: UInt = (1..3).sumOf { (1u..6u).random() }

        return when (diceResult) {
            3u -> if (Random.nextBoolean()) "Chaotic evil" else "Chaotic neutral"
            in 4u..5u -> "Lawful evil"
            in 6u..8u -> "Neutral evil"
            in 9u..12u -> "Neutral"
            in 13u..15u -> "Neutral good"
            in 16u..17u -> listOf("Lawful good", "Lawful neutral").random()
            else -> listOf("Chaotic good", "Chaotic neutral").random()
        }
    }

    fun randomCauseOfDeath(): String {
        val diceResult: UInt = (1u..12u).random()

        return when (diceResult) {
            1u -> "Unknown"
            2u -> "Murdered"
            3u -> "Killed in battle"
            4u -> listOf("Accident related to class", "Accident related to occupation").random()
            5u -> listOf("Accident unrelated to class", "Accident unrelated to occupation").random()
            in 6u..7u -> "Naturas causes, such as disease or old age"
            8u -> "Apparent suicide"
            9u -> listOf("Torn apart by an animal", "Natural disaster").random()
            10u -> "Consumed by a monster"
            11u -> listOf("Executed for a crime", "Tortured to death").random()
            else -> "Bizarre event, such as being hit by a meteorite, struck down by an angry god, or killed by a hatching slaad egg"
        }
    }

    fun randomClass(): Class {
        val diceResult: UInt = (1u..100u).random()

        return when (diceResult) {
            in 1u..7u -> Class.BARBARIAN
            in 8u..14u -> Class.BARD
            in 15u..29u -> Class.CLERIC
            in 30u..36u -> Class.DRUID
            in 37u..52u -> Class.FIGHTER
            in 53u..58u -> Class.MONK
            in 59u..64u -> Class.PALADIN
            in 65u..70u -> Class.RANGER
            in 71u..84u -> Class.ROGUE
            in 85u..89u -> Class.SORCERER
            in 90u..94u -> Class.WARLOCK
            else -> Class.WIZARD
        }
    }

    fun randomOccupation(): String {
        val diceResult: UInt = (1u..100u).random()

        return when (diceResult) {
            in 1u..5u -> "Academic"
            in 6u..10u -> "Adventurer (${randomClass()})"
            11u -> "Aristocrat"
            in 12u..26u -> listOf("Artisan", "Guild member").random()
            in 27u..31u -> "Criminal"
            in 32u..36u -> "Entertainer"
            in 37u..38u -> listOf("Exile", "Hermit", "Refugee").random()
            in 39u..43u -> listOf("Explorer", "Wanderer").random()
            in 44u..55u -> listOf("Farmer", "Herder").random()
            in 56u..60u -> listOf("Hunter", "Trapper").random()
            in 61u..75u -> "Laborer"
            in 76u..80u -> "Merchant"
            in 81u..85u -> listOf("Politician", "Bureaucrat").random()
            in 86u..90u -> "Priest"
            in 91u..95u -> "Sailor"
            else -> "Soldier"
        }
    }

    fun randomRace(): Race? {
        val diceResult: UInt = (1u..100u).random()

        return when (diceResult) {
            in 1u..40u -> Race.HUMAN
            in 41u..50u -> Race.DWARF
            in 51u..60u -> Race.ELF
            in 61u..70u -> Race.HALFLING
            in 71u..75u -> Race.DRAGONBORN
            in 76u..80u -> Race.GNOME
            in 81u..85u -> Race.HALF_ELF
            in 86u..90u -> Race.HALF_ORC
            in 91u..95u -> Race.TIEFLING
            else -> null
        }
    }

    fun randomRelationship(): String {
        val diceResult: UInt = (1..3).sumOf { (1u..4u).random() }

        return when (diceResult) {
            in 3u..4u -> "Hostile"
            in 5u..10u -> "Friendly"
            else -> "Indifferent"
        }
    }

    fun randomStatut(): String {
        val diceResult: UInt = (1..3).sumOf { (1u..6u).random() }

        return when (diceResult) {
            3u -> "Dead (${randomCauseOfDeath()})"
            in 4u..5u -> listOf("Missing", "Unknown").random()
            in 6u..8u -> "Alive, but doing poorly due to ${listOf("injury", "financial trouble", "relatioship difficulties").random()}"
            in 9u..12u -> "Alive and well"
            in 13u..15u -> "Alive and quite successful"
            in 16u..17u -> "Alive and infamous"
            else -> "Alive and famous"
        }
    }
}