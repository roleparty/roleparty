package app.roleparty.tiyl.name

import app.roleparty.tiyl.HumanEthnicity
import app.roleparty.tiyl.HumanEthnicity.*

object HumanNameGeneratorFactory {

    fun getGeneratorFor(ethnicity: HumanEthnicity): HumanNameGenerator {
        return when (ethnicity) {
            ARABIC -> ArabicHumanNameGenerator
            BAROVIAN -> BarovianHumanNameGenerator
            CELTIC -> CelticHumanNameGenerator
            CHINESE -> ChineseHumanNameGenerator
            EGYPTIAN -> EgyptianHumanNameGenerator
            ENGLISH -> EnglishHumanNameGenerator
            FRENCH -> FrenchHumanNameGenerator
            GERMAN -> GermanHumanNameGenerator
            GREEK -> GreekHumanNameGenerator
            INDIAN -> IndianHumanNameGenerator
            JAPANESE -> JapaneseHumanNameGenerator
            MAORI -> MaoriHumanNameGenerator
            MESOAMERICAN -> MesoamericanHumanNameGenerator
            NIGERIAN -> NigerianHumanNameGenerator
            NORSE -> NorseHumanNameGenerator
            POLYNESIAN -> PolynesianHumanNameGenerator
            ROMAN -> RomanHumanNameGenerator
            SLAVIC -> SlavicHumanNameGenerator
            SPANISH -> SpanishHumanNameGenerator
        }
    }
}