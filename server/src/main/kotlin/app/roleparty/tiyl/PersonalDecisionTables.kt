object PersonalDecisionTables {

    object Background {

        fun randomAcolyte(): String {
            return listOf(
                "I ran away from home at an early age and found refuge in a temple.",
                "My family gave me to a temple, since they were unable or unwilling to care for me.",
                "I grew up in a household with strong religious convictions. Entering the service of one or more gods seemed natural.",
                "An impassioned sermon struck a chord deep in my soul and moved me to serve the faith.",
                "I followed a childhood friend, a respected acquaintance, or someone I loved into religious service.",
                "After encountering a true servant of the gods, I was so inspired that I immediately entered the service of a religious group."
            ).random()
        }

        fun randomCharlatan(): String {
            return listOf(
                "I was left to my own devices, and my knack for manipulating others helped me survive.",
                "I learned early on that people are gullible and easy to exploit.",
                "I often got in trouble, but I managed to talk my way out of it every time.",
                "I took up with a confidence artist, from whom I learned my craft.",
                "After a charlatan fleeced my family, I decided to learn the trade so I would never be fooled by such deception again.",
                "I was poor or I feared becoming poor, so I learned the tricks I needed to keep myself out of poverty.",
            ).random()
        }

        fun randomCriminal(): String {
            return listOf(
                "I resented authority in my younger days and saw a life of crime as the best way to fight against tyranny and oppression.",
                "Necessity forced me to take up the life, since it was the only way I could survive.",
                "I fell in with a gang of reprobates and ne'er-do-wells, and I learned my specialty from them.",
                "A parent or relative taught me my criminal specialty to prepare me for the family business.",
                "I left home and found a place in a thieves' guild or some other criminal organization.",
                "I was always bored, so I turned to crime to pass the time and discovered I was quite good at it.",
            ).random()
        }

        fun randomEntertainer(): String {
            return listOf(
                "Members of my family made ends meet by performing, so it was fitting for me to follow their example.",
                "I always had a keen insight into other people, enough so that I could make them laugh or cry with my stories or songs.",
                "I ran away from home to follow a minstrel troupe.",
                "I saw a bard perform once, and I knew from that moment on what I was born to do.",
                "I earned coin by performing on street corners and eventually made a name for myself.",
                "A traveling entertainer took me in and taught me the trade.",
            ).random()
        }

        fun randomFolkHero(): String {
            return listOf(
                "I learned what was right and wrong from my family.",
                "I was always enamored by tales of heroes and wished I could be something more than ordinary.",
                "I hated my mundane life, so when it was time for someone to step up and do the right thing, I took my chance.",
                "A parent or one of my relatives was an adventurer, and I was inspired by that person's courage.",
                "A mad old hermit spoke a prophecy when I was born, saying that I would accomplish great things.",
                "I have always stood up for those who are weaker than I am.",
            ).random()
        }

        fun randomGuildArtisan(): String {
            return listOf(
                "I was apprenticed to a master who taught me the guild's business.",
                "I helped a guild artisan keep a secret or complete a task, and in return I was taken on as an apprentice.",
                "One of my family members who belonged to the guild made a place for me.",
                "I was always good with my hands, so I took the opportunity to learn a trade.",
                "I wanted to get away from my home situation and start a new life.",
                "I learned the essentials of my craft from a mentor but had to join the guild to finish my training.",
            ).random()
        }

        fun randomHermit(): String {
            return listOf(
                "My enemies ruined my reputation, and I fled to the wilds to avoid further disparagement.",
                "I am comfortable with being isolated, as I seek inner peace.",
                "I never liked the people I called my friends, so it was easy for me to strike out on my own.",
                "I felt compelled to forsake my past, but did so with great reluctance, and sometimes I regret making that decision.",
                "I lost everything-my home, my family, my friends. Going it alone was all I could do.",
                "Society's decadence disgusted me, so I decided to leave it behind.",
            ).random()
        }

        fun randomNoble(): String {
            return listOf(
                "I come from an old and storied family, and it fell to me to preserve the family name.",
                "My family has been disgraced, and I intend to clear our name.",
                "My family recently came by its title, and that elevation thrust us into a new and strange world.",
                "My family has a title, but none of my ancestors have distinguished themselves since we gained it.",
                "My family is filled with remarkable people. I hope to live up to their example.",
                "I hope to increase my family's power and influence.",
            ).random()
        }

        fun randomOutlander(): String {
            return listOf(
                "I spent a lot of time in the wilderness as a youngster, and I came to love that way of life.",
                "From a young age, I couldn't abide the stink of the cities and preferred to spend my time in nature.",
                "I came to understand the darkness that lurks in the wilds, and I vowed to combat it.",
                "My people lived on the edges of civilization, and I learned the methods of survival from my family.",
                "After a tragedy I retreated to the wilderness, leaving my old life behind.",
                "My family moved away from civilization, and I learned to adapt to my new environment.",
            ).random()
        }

        fun randomSage(): String {
            return listOf(
                "I was naturally curious, so I packed up and went to a university to learn more about the world.",
                "My mentor's teachings opened my mind to new possibilities in that field of study.",
                "I was always an avid reader, and I learned much about my favorite topic on my own.",
                "I discovered an old library and pored over the texts I found there. That experience awakened a hunger for more knowledge.",
                "I impressed a wizard who told me I was squandering my talents and should seek out an education to take advantage of my gifts.",
                "One of my parents or a relative gave me a basic education that whetted my appetite, and I left home to build on what I had learned.",
            ).random()
        }

        fun randomSailor(): String {
            return listOf(
                "I was press-ganged by pirates and forced to serve on their ship until I finally escaped.",
                "I wanted to see the world, so I signed on as a deck-hand for a merchant ship.",
                "One of my relatives was a sailor who took me to sea.",
                "I needed to escape my community quickly, so I stowed away on a ship. When the crew found me, I was forced to work for my passage.",
                "Reavers attacked my community, so I found refuge on a ship until I could seek vengeance.",
                "I had few prospects where I was living, so I left to find my fortune elsewhere.",
            ).random()
        }

        fun randomSoldier(): String {
            return listOf(
                "I joined the militia to help protect my community from monsters.",
                "A relative of mine was a soldier, and I wanted to carry on the family tradition.",
                "The local lord forced me to enlist in the army.",
                "War ravaged my homeland while I was growing up. Fighting was the only life I ever knew.",
                "I wanted fame and fortune, so I joined a mercenary company, selling my sword to the highest bidder.",
                "Invaders attacked my homeland. It was my duty to take up arms in defense of my people.",
            ).random()
        }

        fun randomUrchin(): String {
            return listOf(
                "Wanderlust caused me to leave my family to see the world. I look after myself.",
                "I ran away from a bad situation at home and made my own way in the world.",
                "Monsters wiped out my village, and I was the sole survivor. I had to find a way to survive.",
                "A notorious thief looked after me and other orphans, and we spied and stole to earn our keep.",
                "One day I woke up on the streets, alone and hungry, with no memory of my early childhood.",
                "My parents died, leaving no one to look after me. I raised myself.",
            ).random()
        }
    }


    object ClassTraining {

        fun randomBarbarian(): String {
            return listOf(
                "My devotion to my people lifted me in battle, making me powerful and dangerous.",
                "The spirits of my ancestors called on me to carry out a great task.",
                "I lost control in battle one day, and it was as if something else was manipulating my body, forcing it to kill every foe I could reach.",
                "I went on a spiritual journey to find myself and instead found a spirit animal to guide, protect, and inspire me.",
                "I was struck by lightning and lived. Afterward, I found a new strength within me that let me push beyond my limitations.",
                "My anger needed to be channeled into battle, or I risked becoming an indiscriminate killer."
            ).random()
        }

        fun randomBard(): String {
            return listOf(
                "I awakened my latent bardic abilities through trial and error.",
                "I was a gifted performer and attracted the attention of a master bard who schooled me in the old techniques.",
                "I joined a loose society of scholars and orators to learn new techniques of performance and magic.",
                "I felt a calling to recount the deeds of champions and heroes, to bring them alive in song and story.",
                "I joined one of the great colleges to learn old lore, the secrets of magic, and the art of performance.",
                "I picked up a musical instrument one day and instantly discovered that I could play it."
            ).random()
        }

        fun randomCleric(): String {
            return listOf(
                "A supernatural being in service to the gods called me to become a divine agent in the world.",
                "I saw the injustice and horror in the world and felt moved to take a stand against them.",
                "My god gave me an unmistakable sign. I dropped everything to serve the divine.",
                "Although I was always devout, it wasn't until I completed a pilgrimage that I knew my true calling.",
                "I used to serve in my religion's bureaucracy but found I needed to work in the world, to bring the message of my faith to the darkest corners of the land.",
                "I realize that my god works through me, and I do as commanded, even though I don't know why I was chosen to serve."
            ).random()
        }

        fun randomDruid(): String {
            return listOf(
                "I saw too much devastation in the wild places, too much of nature's splendor ruined by the despoilers. I joined a circle of druids to fight back against the enemies of nature.",
                "I found a place among a group of druids after I fled a catastrophe.",
                "I have always had an affinity for animals, so I explored my talent to see how I could best use it.",
                "I befriended a druid and was moved by druidic teachings. I decided to follow my friend's guidance and give something back to the world.",
                "While I was growing up, I saw spirits all around me — entities no one else could perceive. I sought out the druids to help me understand the visions and communicate with these beings.",
                "I have always felt disgust for creatures of unnatural origin. For this reason, I immersed myself in the study of the druidic mysteries and became a champion of the natural order."
            ).random()
        }

        fun randomFighter(): String {
            return listOf(
                "I wanted to hone my combat skills, and so I joined a war college.",
                "I squired for a knight who taught me how to fight, care for a steed , and conduct myself with honor. I decided to take up that path for myself.",
                "Horrible monsters descended on my community, killing someone I loved. I took up arms to destroy those creatures and others of a similar nature.",
                "I joined the army and learned how to fight as part of a group.",
                "I grew up fighting, and I refined my talents by defending myself against people who crossed me.",
                "I could always pick up just about any weapon and know how to use it effectively."
            ).random()
        }

        fun randomMonk(): String {
            return listOf(
                "I was chosen to study at a secluded monastery. There, I was taught the fundamental techniques required to eventually master a tradition.",
                "I sought instruction to gain a deeper understanding of existence and my place in the world.",
                "I stumbled into a portal to the Shadowfell and took refuge in a strange monastery, where I learned how to defend myself against the forces of darkness.",
                "I was overwhelmed with grief after losing someone close to me, and I sought the advice of philosophers to help me cope with my loss.",
                "I could feel that a special sort of power lay within me, so I sought out those who could help me call it forth and master it.",
                "I was wild and undisciplined as a youngster, but then I realized the error of my ways. I applied to a monastery and became a monk as a way to live a life of discipline."
            ).random()
        }

        fun randomPaladin(): String {
            return listOf(
                "A fantastical being appeared before me and called on me to undertake a holy quest.",
                "One of my ancestors left a holy quest unfulfilled, so I intend to finish that work.",
                "The world is a dark and terrible place. I decided to serve as a beacon of light shining out against the gathering shadows.",
                "I served as a paladin's squire, learning all I needed to swear my own sacred oath.",
                "Evil must be opposed on all fronts. I feel compelled to seek out wickedness and purge it from the world.",
                "Becoming a paladin was a natural consequence of my unwavering faith. In taking my vows, I became the holy sword of my religion."
            ).random()
        }

        fun randomRanger(): String {
            return listOf(
                "I found purpose while I honed my hunting skills by bringing down dangerous animals at the edge of civilization.",
                "I always had a way with animals, able to calm them with a soothing word and a touch.",
                "I suffer from terrible wanderlust, so being a ranger gave me a reason not to remain in one place for too long.",
                "I have seen what happens when the monsters come out from the dark. I took it upon myself to become the first line of defense against the evils that lie beyond civilization's borders.",
                "I met a grizzled ranger who taught me woodcraft and the secrets of the wild lands.",
                "I served in an army, learning the precepts of my profession while blazing trails and scouting enemy encampments."
            ).random()
        }

        fun randomRogue(): String {
            return listOf(
                "I've always been nimble and quick of wit, so I decided to use those talents to help me make my way in the world.",
                "An assassin or a thief wronged me, so I focused my training on mastering the skills of my enemy to better combat foes of that sort.",
                "An experienced rogue saw something in me and taught me several useful tricks.",
                "I decided to turn my natural lucky streak into the basis of a career, though I still realize that improving my skills is essential.",
                "I took up with a group of ruffians who showed m e how to get what I want through sneakiness rather than direct confrontation.",
                "I'm a sucker for a shiny bauble or a sack of coins, as long as I can get my hands on it without risking life and limb."
            ).random()
        }

        fun randomSorcerer(): String {
            return listOf(
                "When I was born, all the water in the house froze solid , the milk spoiled, or all the iron turned to copper. My family is convinced that this event was a harbinger of stranger things to come for me.",
                "I suffered a terrible emotional or physical strain, which brought forth my latent magical power. I have fought to control it ever since.",
                "My immediate family never spoke of my ancestors, and when I asked, they would change the subject. It wasn't until I started displaying strange talents that the full truth of my heritage came out.",
                "When a monster threatened one of my friends, I became filled with anxiety. I lashed out instinctively and blasted the wretched thing with a force that came from within me.",
                "Sensing something special in me, a stranger taught me how to control my gift.",
                "After I escaped from a magical conflagration, I realized that though I was unharmed, I was not unchanged. I began to exhibit unusual abilities that I am just beginning to understand."
            ).random()
        }

        fun randomWarlock(): String {
            return listOf(
                "While wandering around in a forbidden place, I encountered an otherworldly being that offered to enter into a pact with me.",
                "I was examining a strange tome I found in an abandoned library when the entity that would become my patron suddenly appeared before me.",
                "I stumbled into the clutches of my patron after I accidentally stepped through a magical doorway.",
                "When I was faced with a terrible crisis, I prayed to any being who would listen, and the creature that answered became my patron.",
                "My future patron visited me in my dreams and offered great power in exchange for my service.",
                "One of my ancestors had a pact with my patron, so that entity was determined to bind me to the same agreement."
            ).random()
        }

        fun randomWizard(): String {
            return listOf(
                "An old wizard chose me from among several candidates to serve an apprenticeship.",
                "When I became lost in a forest, a hedge wizard found me, took me in, and taught me the rudiments of magic.",
                "I grew up listening to tales of great wizards and knew I wanted to follow their path. I strove to be accepted at an academy of magic and succeeded.",
                "One of my relatives was an accomplished wizard who decided I was smart enough to learn the craft.",
                "While exploring an old tomb, library, or temple, I found a spellbook. I was immediately driven to learn all I could about becoming a wizard.",
                "I was a prodigy who demonstrated mastery of the arcane arts at an early age. When I became old enough to set out on my own, I did so to learn more magic and expand my power."
            ).random()
        }
    }
}