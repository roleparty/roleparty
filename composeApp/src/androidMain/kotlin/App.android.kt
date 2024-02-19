import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset

actual fun Modifier.interactions(
    onPointerMove: (position: Offset) -> Unit,
    onScroll: (position: Offset) -> Unit
): Modifier {
    return this
}