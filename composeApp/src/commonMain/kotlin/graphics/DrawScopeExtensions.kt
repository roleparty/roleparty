package graphics

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

const val purpleHue = 291.3f
const val purpleSaturation = 0.48f
const val purpleLightness = 0.784f
val purpleColor = Color.hsl(purpleHue, purpleSaturation, purpleLightness)
val darkenPurpleColor = Color.hsl(purpleHue, purpleSaturation, purpleLightness - 0.1f)


fun DrawScope.drawSquare(square: InteractiveSquare) = drawRect(
    color = darkenPurpleColor,
    topLeft = square.topLeftPosition,
    size = Size(square.side, square.side)
)

fun DrawScope.drawCircle(circle: InteractiveCircle) = drawCircle(
    color = darkenPurpleColor,
    center = circle.center,
    radius = circle.radius
)