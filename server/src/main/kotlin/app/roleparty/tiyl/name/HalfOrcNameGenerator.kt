package app.roleparty.tiyl.name

import app.roleparty.tiyl.Gender

object HalfOrcNameGenerator : CharacterNameGenerator {
    override fun generateFullName(gender: Gender): String {
        return  when (gender) {
            Gender.MALE -> MALE_NAMES.random()
            Gender.FEMALE -> FEMALE_NAMES.random()
        }
    }
    
    private val FEMALE_NAMES = listOf(
        "Arha",
        "Baggi",
        "Bendoo",
        "Bilga",
        "Brakka",
        "Creega",
        "Drenna",
        "Ekk",
        "Emen",
        "Engong",
        "Fistula",
        "Gaaki",
        "Gorga",
        "Grai",
        "Greeba",
        "Grigi",
        "Gynk",
        "Hrathy",
        "Huru",
        "Ilga",
        "Kabbarg",
        "Kansif",
        "Lagazi",
        "Lezre",
        "Murgen",
        "Murook",
        "Myev",
        "Nagrette",
        "Neega",
        "Nella",
        "Nogu",
        "Oolah",
        "Ootah",
        "Ovak",
        "Ownka",
        "Puyet",
        "Reeza",
        "Shautha",
        "Silgre",
        "Sutha",
        "Tagga",
        "Tawar",
        "Tomph",
        "Ubada",
        "Vanchu",
        "Vola",
        "Volen",
        "Vorka",
        "Yevelda",
        "Zagga"
    )

    private val MALE_NAMES = listOf(
        "Argran",
        "Braak",
        "Brug",
        "Cagak",
        "Dench",
        "Dorn",
        "Dren",
        "Druuk",
        "Feng",
        "Gell",
        "Gnarsh",
        "Grumbar",
        "Gubrash",
        "Hagren",
        "Henk",
        "Hogar",
        "Holg",
        "Imsh",
        "Karash",
        "Karg",
        "Keth",
        "Korag",
        "Krusk",
        "Lubash",
        "Megged",
        "Mhurren",
        "Mord",
        "Morg",
        "Nil",
        "Nybarg",
        "Odorr",
        "Ohr",
        "Rendar",
        "Resh",
        "Ront",
        "Rrath",
        "Sark",
        "Scrag",
        "Sheggen",
        "Shump",
        "Tanglar",
        "Tarak",
        "Thar",
        "Thokk",
        "Trag",
        "Ugarth",
        "Varg",
        "Vilberg",
        "Yurk",
        "Zed"
    )
}