package com.muhammadsayed.ramadanmubark


import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class IslamicPatternShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val w = size.width
        val tipSize = w / 7
        val h = size.height
        val path = Path().apply {

            moveTo(w / 2, 0f)
            lineTo((w / 2) + (tipSize), tipSize)
            lineTo(w - tipSize, tipSize)
            lineTo(w - tipSize, (h / 2) - (tipSize))
            lineTo(w, (h / 2))

            lineTo(w - tipSize, (h / 2) + (tipSize))
            lineTo(w - tipSize, h - tipSize)

            lineTo((w / 2) + (tipSize), h - tipSize)
            lineTo((w / 2), h)
            lineTo((w / 2) - (tipSize), h - tipSize)

            lineTo(tipSize, h - tipSize)

            lineTo(tipSize, (h / 2) + (tipSize))
            lineTo(0f, h / 2)
            lineTo(tipSize, (h / 2) - (tipSize))
            lineTo(tipSize, tipSize)
            lineTo((w / 2) - (tipSize), tipSize)

            close()

        }
        return Outline.Generic(path)
    }
}