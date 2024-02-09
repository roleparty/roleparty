import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun MonsterComponent(monster: Monster) = Column {
    Text(
        text = monster.name,
        style = MaterialTheme.typography.headlineLarge
    )
    Text(
        text = "${monster.size.name} ${monster.type}, ${monster.alignement}".capitalizeWords(),
        fontStyle = FontStyle.Italic
    )
    Divider()
    KeyValue("Armor Class", monster.armorClass.toString())
    KeyValue("Hit Points", "${monster.hitPoints.value} (${monster.hitPoints.dice})")
    KeyValue("Speed", monster.speeds.map { "${it.type.name} ${it.value}ft." }.joinToString(", ").capitalizeWords())
    Divider()
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
private fun MainAbility()