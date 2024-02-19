import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent

@OptIn(ExperimentalComposeUiApi::class)
actual fun Modifier.interactions(
    onPointerMove: (position: Offset) -> Unit,
    onScroll: (position: Offset) -> Unit
) = onPointerEvent(PointerEventType.Move) { event ->  
    event.changes.forEach { pointerInputChange -> onPointerMove(pointerInputChange.position) }
}