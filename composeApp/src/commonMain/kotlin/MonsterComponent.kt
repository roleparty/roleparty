import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun MonsterComponent(monster: Monster) = Column(
    modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(8.dp)
        .width(IntrinsicSize.Max),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    Column {
        Text(
            text = monster.name,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "${monster.size.name} ${monster.type}, ${monster.alignment}".capitalizeWords(),
            fontStyle = FontStyle.Italic
        )
    }
    SimpleCard {
        KeyValue("Armor Class", monster.armorClass.toString())
        KeyValue("Hit Points", "${monster.hitPoints.value} (${monster.hitPoints.dice})")
        KeyValue(
            "Speed",
            monster.speeds.values.joinToString(", ") { "${it.movementType.name} ${it.speed.distance.value}ft." }
                .capitalizeWords()
        )
    }
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        monster.abilities.toList().forEach {
            MonsterInformationCard(
                modifier = Modifier.width(120.dp)
            ) {
                MainAbility(it)
            }
        }
    }
    MonsterInformationCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        KeyValue(
            "Saving Throws",
            monster.savingThrows.values.joinToString(", ") { "${it.ability.abbreviation.capitalizeWords()} ${it.modifier}" }
        )
        KeyValue(
            "Skills",
            monster.skills.toString()
        )
        KeyValue(
            "Senses",
            monster.senses.joinToString(", ") { it.label }
        )
        KeyValue(
            "Languages",
            monster.languages.joinToString(", ") { it.label }
        )
        KeyValue(
            "Challenge",
            monster.challengeRating.toString()
        )
    }

    ExpandableCard("Special Abilities") {
        monster.specialAbilities.forEach { SpecialAbilityDescription(it) }
    }
    ExpandableCard("Actions") {
        monster.actions.forEach { ActionDescription(it) }
    }
    ExpandableCard("Legendary Actions") {
        Text(monster.legendaryActionsDescripion)
        monster.legendaryActions.forEach { ActionDescription(it) }
    }
}

@Composable
private fun KeyValue(key: String, value: String) {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(key)
            }
            append(" ")
            append(value)
        }
    )
}

@Composable
private fun MainAbility(
    ability: Ability
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxWidth()
) {
    Text(
        text = ability.type.abbreviation,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "${ability.value} (${ability.modifier})"
    )
}

@Composable
private fun SpecialAbilityDescription(
    specialAbility: SpecialAbility
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
                append("${specialAbility.name}. ")
            }
            append(specialAbility.description)
        }
    )
}

@Composable
private fun ActionDescription(
    action: Action
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
                append("${action.name}. ")
            }
            append(action.description)
        }
    )
}

@Composable
private fun MonsterInformationCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) = Card(
    modifier = modifier
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        content()
    }
}