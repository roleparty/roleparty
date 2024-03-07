package app.roleparty.tiyl.name

import app.roleparty.tiyl.Gender

interface CharacterNameGenerator {

    fun generateFullName(gender: Gender): String
}