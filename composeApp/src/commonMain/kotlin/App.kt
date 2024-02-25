import Mode.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import graph.*

enum class Mode {
    CITY,
    CHARACTER,
    RELATION
}

data class Line(
    val start: Offset,
    val end: Offset
)

// use class instead of data class / value class cause we want
// equals based on wrapper reference to refresh canvas
// by mutable state
class Wrapper<T>(val value: T) {
    fun copy() = Wrapper(value)
}

@Composable
fun App() {
    MaterialTheme {
        var selectedMode by remember { mutableStateOf(CITY) }
        var selectedItem by remember { mutableStateOf<InteractiveElement?>(null) }
        var graph by remember { mutableStateOf(Wrapper(InteractiveGraph())) }

        var temporaryLine by remember { mutableStateOf<Line?>(null) }

        Column {
            Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                Mode.entries.forEach { mode ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(mode.name)
                        RadioButton(
                            selected = selectedMode == mode,
                            onClick = { selectedMode = mode },
                        )
                    }
                }
            }

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = { position ->
                                when (selectedMode) {
                                    CITY -> {
                                        graph.value.addVertex(City(position, "My City"))
                                        graph = graph.copy()
                                    }

                                    CHARACTER -> {
                                        graph.value.addVertex(User(position, "Thoradin", "FORGEFEU"))
                                        graph = graph.copy()
                                    }

                                    RELATION -> {}
                                }
                            }
                        )
                    }
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = { offset ->
                                when (selectedMode) {
                                    CITY, CHARACTER -> {
                                        selectedItem = graph.value[offset]
                                    }

                                    RELATION -> {
                                        graph.value[offset]?.let {
                                            temporaryLine = Line(it.center, it.center)
                                        }
                                    }
                                }
                            },
                            onDragEnd = {
                                selectedItem = null
                                when (selectedMode) {
                                    CITY, CHARACTER -> {

                                    }

                                    RELATION -> temporaryLine?.let {
                                        graph.value[it.end]?.let { hoveredItemIndex ->
                                            graph.value[it.start]?.let { itemStartingLine ->
                                                val endpoints = Pair(itemStartingLine, hoveredItemIndex)
                                                graph.value.setEdge(endpoints, Relation(""))
                                                graph = graph.copy()
                                            }
                                        }
                                        temporaryLine = null
                                    }
                                }
                            },
                            onDragCancel = {
                                selectedItem = null
                                temporaryLine = null
                            },
                            onDrag = { change, translation ->
                                when (selectedMode) {
                                    CITY, CHARACTER -> {
                                        selectedItem?.let {
                                            it.translate(translation)
                                            graph = graph.copy()
                                        }
                                    }

                                    RELATION -> temporaryLine = temporaryLine?.let {
                                        graph.value[change.position]?.let { hoveredItemIndex ->
                                            it.copy(end = hoveredItemIndex.center)
                                        } ?: it.copy(end = change.position)
                                    }
                                }
                            }
                        )
                    }
            ) {

                temporaryLine?.let {
                    drawLine(
                        color = Color.Black,
                        start = it.start,
                        end = it.end,
                        strokeWidth = 6f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )
                }

                graph.value.edgesSnapshot().forEach { edge ->
                    selectedItem
                        ?.takeIf { it == edge.start || it == edge.end }
                        ?.let {
                            drawLine(
                                color = Color.Black,
                                start = edge.start.center,
                                end = edge.end.center,
                                strokeWidth = 6f
                            )
                        } ?: run {
                            drawLine(
                                color = Color.LightGray,
                                start = edge.start.center,
                                end = edge.end.center,
                                strokeWidth = 6f
                            )
                        }
                }

                graph.value.verticesSnapshot().forEach {
                    when (it) {
                        is City -> drawRect(
                            color = Color.Blue,
                            topLeft = it.topLeft,
                            size = Size(it.side, it.side)
                        )

                        is User -> drawCircle(
                            color = Color.Blue,
                            center = it.center,
                            radius = it.radius
                        )
                    }
                }
            }
        }
    }
}