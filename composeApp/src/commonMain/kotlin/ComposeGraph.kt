import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun Graph() {

    val vertices = remember { mutableStateListOf<Vertex<String>>() }
    val edges = remember { mutableStateListOf<Edge<String>>() }
    var selectedVertexIndex by remember { mutableStateOf<Int?>(null) }
    var canvasTopLeftOffset by remember { mutableStateOf(Offset(0f, 0f)) }

    val select = { index: Int ->
        selectedVertexIndex = index
    }

    val unselect = {
        selectedVertexIndex = null
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { offset ->
                        println("ON TAP")
                        vertices.add(Vertex(offset - canvasTopLeftOffset, ""))
                        if (vertices.size % 2 == 0) {
                            edges.add(Edge(Pair(vertices.size - 2, vertices.size - 1), ""))
                        }
                    },
                    onPress = { offset ->
                        println("ON PRESS")
                        val index = vertices.indexOfFirst { it.isPositionedOn(offset - canvasTopLeftOffset) }
                        if (index != -1) {
                            select(index)
                        }
                    }
                )
            }
            .pointerInput(Unit) {
                detectDragGestures(
                    onDrag = { change, dragAmount ->
                        println("ON DRAG")
                        selectedVertexIndex?.let {
                            vertices[it] = vertices[it].translate(dragAmount)
                        } ?: run {
                            canvasTopLeftOffset += dragAmount
                        }
                    },
                    onDragStart = { offset ->
                        println("ON DRAG START")
                        val index = vertices.indexOfFirst { it.isPositionedOn(offset) }
                        if (index != -1) {
                            select(index)
                        }
                    },
                    onDragEnd = {
                        println("ON DRAG END")
                        unselect()
                    },
                    onDragCancel = {
                        println("ON DRAG CANCEL")
                        unselect()
                    }
                )
            }
    ) {
        drawRect(Color.White)

        edges.forEach {
            drawLine(
                color = if (it.endpoints.first == selectedVertexIndex || it.endpoints.second == selectedVertexIndex) Color.Red else Color.Black,
                start = vertices[it.endpoints.first].position + canvasTopLeftOffset,
                end = vertices[it.endpoints.second].position + canvasTopLeftOffset,
                strokeWidth = 4f
            )
        }

        vertices.forEachIndexed { index, vertex ->
            drawRect(
                color = Color.Black,
                topLeft = vertex.position - Offset(30f, 30f) + canvasTopLeftOffset,
                size = Size(60f, 60f),
            )
            if (index == selectedVertexIndex) {
                drawRect(
                    color = Color.Red,
                    topLeft = vertex.position - Offset(30f, 30f) + canvasTopLeftOffset,
                    size = Size(60f, 60f),
                    style = Stroke(8f)
                )
            }
        }
    }
}

private data class Vertex<T>(
    val position: Offset,
    val value: T
) {
    fun translate(amount: Offset) = copy(position = position + amount, value = value)

    fun isPositionedOn(position: Offset): Boolean {
        return this.position.x in (position.x - 30f)..(position.x + 30f)
                && this.position.y in (position.y - 30f)..(position.y + 30f)
    }
}

private data class Edge<T>(
    val endpoints: Pair<Int, Int>,
    val value: T
)