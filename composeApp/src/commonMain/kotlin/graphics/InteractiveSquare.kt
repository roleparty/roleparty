package graphics

import androidx.compose.ui.geometry.Offset

const val SQUARE_SIDE = 100f

class InteractiveSquare(
    val topLeftPosition: Offset,
    val side: Float = SQUARE_SIDE
) : InteractiveGraphicElement<InteractiveSquare>(topLeftPosition.plus(Offset(side / 2, side / 2))) {

    private val abscissas by lazy { topLeftPosition.x..(topLeftPosition.x + side) }
    private val ordinates by lazy { topLeftPosition.y..(topLeftPosition.y + side) }

    companion object {
        fun withCenter(position: Offset, side: Float = SQUARE_SIDE): InteractiveSquare {
            return InteractiveSquare(position.minus(Offset(side / 2, side / 2)))
        }
    }

    override fun isPositionedOn(offset: Offset) = offset.x in abscissas && offset.y in ordinates

    override fun withTranslation(translation: Offset) = InteractiveSquare(topLeftPosition + translation)
}