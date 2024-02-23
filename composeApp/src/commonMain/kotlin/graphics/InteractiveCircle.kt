package graphics

import androidx.compose.ui.geometry.Offset
import kotlin.math.pow

const val CIRCLE_RADIUS = 100f

class InteractiveCircle(
    center: Offset,
) : InteractiveGraphicElement<InteractiveCircle>(center) {

    val radius: Float = CIRCLE_RADIUS

    override fun isPositionedOn(offset: Offset) =
        (offset.x - center.x).pow(2) + (offset.y - center.y).pow(2) < radius.pow(2)

    override fun withTranslation(translation: Offset) = InteractiveCircle(center + translation)
}