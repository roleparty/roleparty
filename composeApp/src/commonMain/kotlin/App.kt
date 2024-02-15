import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun App() {
    MaterialTheme {
        val monster = Monster(
            name = "Aboleth",
            type = "Aberration",
            size = Size.LARGE,
            alignment = "Lawful Evil",
            armorClass = 17u,
            hitPoints = HitPoints(
                value = 135u,
                dice = "18d10+36"
            ),
            speeds = MovementSpeedSet(
                walk = 10u,
                swim = 40u
            ),
            abilities = AbilitySet(
                strength = 21u,
                dexterity = 9u,
                constitution = 15u,
                intelligence = 18u,
                wisdom = 15u,
                charisma = 18u,
            ),
            skills = SkillSet(
                history = History(12),
                perception = Perception(10),
            ),
            savingThrows = SavingThrowSet(
                constitution = 6,
                intelligence = 8,
                wisdom = 6
            ),
            senses = listOf(
                Sense.darkvision(Distance(120u, Distance.Unit.FEET)),
                Sense("passive Perception 20")
            ),
            languages = listOf(
                Language("Deep Speech"),
                Language("telepathy 120 ft.")
            ),
            challengeRating = ChallengeRating(
                challenge = 10u,
                experience = 5900u
            ),
            specialAbilities = listOf(
                SpecialAbility(
                    "Amphibious",
                    "The aboleth can breathe air and water."
                ),
                SpecialAbility(
                    "Mucous Cloud",
                    "While underwater, the aboleth is surrounded by transformative mucus. A creature that touches the aboleth or that hits it with a melee attack while within 5 feet of it must make a DC 14 Constitution saving throw. On a failure, the creature is diseased for 1d4 hours. The diseased creature can breathe only underwater."
                ),
                SpecialAbility(
                    "Probing Telepathy",
                    "If a creature communicates telepathically with the aboleth, the aboleth learns the creature's greatest desires if the aboleth can see the creature."
                )
            ),
            actions = listOf(
                Action(
                    "Multiattack",
                    "The aboleth makes three tentacle attacks."
                ),
                Action(
                    "Tentacle",
                    "Melee Weapon Attack: +9 to hit, reach 10 ft., one target. Hit: 12 (2d6 + 5) bludgeoning damage. If the target is a creature, it must succeed on a DC 14 Constitution saving throw or become diseased. The disease has no effect for 1 minute and can be removed by any magic that cures disease. After 1 minute, the diseased creature's skin becomes translucent and slimy, the creature can't regain hit points unless it is underwater, and the disease can be removed only by heal or another disease-curing spell of 6th level or higher. When the creature is outside a body of water, it takes 6 (1d12) acid damage every 10 minutes unless moisture is applied to the skin before 10 minutes have passed."
                ),
                Action(
                    "Tail",
                    "Melee Weapon Attack: +9 to hit, reach 10 ft., one target. Hit: 15 (3d6 + 5) bludgeoning damage."
                ),
                Action(
                    "Enslave (3/Day)",
                    "The aboleth targets one creature it can see within 30 feet of it. The target must succeed on a DC 14 Wisdom saving throw or be magically charmed by the aboleth until the aboleth dies or until it is on a different plane of existence from the target. The charmed target is under the aboleth's control and can't take reactions, and the aboleth and the target can communicate telepathically with each other over any distance. Whenever the charmed target takes damage, the target can repeat the saving throw. On a success, the effect ends. No more than once every 24 hours, the target can also repeat the saving throw when it is at least 1 mile away from the aboleth."
                )
            ),
            legendaryActionsDescripion = "The aboleth can take 3 legendary actions, choosing from the options below. Only one legendary action option can be used at a time and only at the end of another creature's turn. The aboleth regains spent legendary actions at the start of its turn.",
            legendaryActions = listOf(
                Action(
                    "Detect",
                    "The aboleth makes a Wisdom (Perception) check."
                ),
                Action(
                    "Tail Swipe",
                    "The aboleth makes one tail attack."
                ),
                Action(
                    "Psychic Drain (Costs 2 Actions)",
                    "One creature charmed by the aboleth takes 10 (3d6) psychic damage, and the aboleth regains hit points equal to the damage the creature takes."
                )
            )
        )

        MonsterComponent(monster)
    }
}