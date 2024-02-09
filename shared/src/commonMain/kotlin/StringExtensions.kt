fun String.capitalizeWords(delimiter: String = " "): String {
    return split(delimiter).joinToString(delimiter) { word ->
        val smallCaseWord = word.lowercase()
        smallCaseWord.replaceFirstChar(Char::titlecaseChar)
    }
}