import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.imageResource
import roleparty.composeapp.generated.resources.Res

data class Indicator(
    val topLeft: Offset,
    val width: Int,
    val height: Int
) : Positionable {

    private val abscissas = topLeft.x..(topLeft.x + width)
    private val ordinates = topLeft.y..(topLeft.y + height)

    override fun contains(offset: Offset) = offset.x in abscissas && offset.y in ordinates
}

data class Element(
    val position: Offset,
    val indicator: Indicator,
    val name: String
) : Positionable {

    override fun contains(offset: Offset) = offset == position
}

interface Positionable {
    fun contains(offset: Offset): Boolean
}

expect fun Modifier.interactions(
    onPointerMove: (position: Offset) -> Unit,
    onScroll: (position: Offset) -> Unit
): Modifier

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        val cityIcon = imageResource(Res.drawable.cityindicator)
        val background = imageResource(Res.drawable.map)

        var canvasTopLeftOffset by remember { mutableStateOf(Offset(0f, 0f)) }

        val elements = remember { mutableStateListOf<Element>() }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .interactions(
                    onPointerMove = { offset ->
                        val translatedOffset = offset.plus(canvasTopLeftOffset)
                        elements.forEach { element ->
                            if (element.indicator.contains(translatedOffset)) {
                                println("TEST")
                            }
                        }
                    },
                    onScroll = { offset ->
                        println(offset)
                    }
                )
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { offset ->
                            elements.add(
                                Element(
                                    position = offset.plus(canvasTopLeftOffset),
                                    indicator = Indicator(
                                        topLeft = Offset(
                                            offset.x - cityIcon.width / 2 + canvasTopLeftOffset.x,
                                            offset.y - cityIcon.height + canvasTopLeftOffset.y
                                        ),
                                        width = cityIcon.width,
                                        height = cityIcon.height
                                    ),
                                    name = "City"
                                )
                            )
                        }
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        canvasTopLeftOffset = canvasTopLeftOffset.minus(Offset(dragAmount.x, dragAmount.y))
                    }
                },
            onDraw = {
                drawImage(
                    image = background,
                    srcOffset = IntOffset(canvasTopLeftOffset.x.toInt(), canvasTopLeftOffset.y.toInt())
                )
                elements
                    .map { it.indicator }
                    .sortedBy { indicator -> indicator.topLeft.y }
                    .forEach { indicator ->
                        drawImage(
                            image = cityIcon,
                            topLeft = indicator.topLeft.minus(canvasTopLeftOffset)
                        )
                    }
            }
        )
    }
}