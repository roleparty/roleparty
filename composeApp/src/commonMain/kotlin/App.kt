import Speed.Type.SWIM
import Speed.Type.WALK
import Speed.Unit.FEET
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun App() {
    MaterialTheme {
        val monster = Monster(
            name = "Aboleth",
            type = "Aberration",
            size = Size.LARGE,
            alignement = "Lawful Evil",
            armorClass = 17u,
            hitPoints = HitPoints(
                value = 135u,
                dice = "18d10+36"
            ),
            speeds = listOf(
                Speed(WALK, 10u, FEET),
                Speed(SWIM, 40u, FEET)
            )
        )

        MonsterComponent(monster)
    }
}