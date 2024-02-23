package graph

import androidx.compose.ui.geometry.Offset
import kotlin.jvm.JvmInline
import kotlin.math.pow

class InteractiveGraph : Graph<InteractiveElement, Relation>() {

    operator fun get(offset: Offset) = vertices.firstOrNull { it.isPositionedOn(offset) }
}

sealed class InteractiveElement(protected var position: Offset) {

    val center get() = position

    abstract fun isPositionedOn(offset: Offset): Boolean

    fun translate(translation: Offset) {
        position += translation
    }
}

class City(position: Offset, val name: String) : InteractiveElement(position) {

    val side = 100f

    val topLeft get() = position.minus(Offset(side / 2, side / 2))

    override fun isPositionedOn(offset: Offset): Boolean {
        return offset.x in (topLeft.x)..(topLeft.x + side) && offset.y in (topLeft.y)..(topLeft.y + side)
    }
}

class User(position: Offset, val givenName: String, val familyName: String) : InteractiveElement(position) {
    val radius: Float = 50f

    override fun isPositionedOn(offset: Offset) =
        (offset.x - center.x).pow(2) + (offset.y - center.y).pow(2) < radius.pow(2)
}

@JvmInline
value class Relation(val value: String)