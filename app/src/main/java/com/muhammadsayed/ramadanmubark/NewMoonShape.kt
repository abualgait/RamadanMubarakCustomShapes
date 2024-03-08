package com.muhammadsayed.ramadanmubark


import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class NewMoonShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val radius = size.minDimension / 3

        val outerPath = Path().apply {
            addArc(
                Rect(
                    left = 0f,
                    top = 0f,
                    right = centerX * 2,
                    bottom = centerY * 2
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 360f
            )
        }

        val innerPath = Path().apply {
            addArc(
                Rect(
                    left = centerX - radius,
                    top = 0f,
                    right = centerX * 2,
                    bottom = centerY * 2
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 360f
            )
        }
        val crescentMoonPath = Path().apply {
            op(outerPath, innerPath, PathOperation.Difference)
        }


        return Outline.Generic(crescentMoonPath)
    }
}