package graphics

import androidx.compose.ui.geometry.Offset

sealed class InteractiveGraphicElement<T : InteractiveGraphicElement<T>>(val center: Offset) : Drawable {

    abstract fun isPositionedOn(offset: Offset): Boolean

    abstract fun withTranslation(translation: Offset): T
}