package app.roleparty.tiyl.name

import app.roleparty.tiyl.Gender

abstract class HumanNameGenerator(
    private val familyNames: List<String>,
    private val maleNames: List<String>,
    private val femaleNames: List<String>
) : CharacterNameGenerator {

    final override fun generateFullName(gender: Gender): String {
        val familyName = familyNames.random()
        val firstName = when (gender) {
            Gender.MALE -> maleNames.random()
            Gender.FEMALE -> femaleNames.random()
        }
        return "$firstName $familyName"
    }
}