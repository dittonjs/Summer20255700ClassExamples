package org.example.project.drawable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

data class Line(val start: Offset, val end: Offset): Drawable() {
    override fun draw(scope: DrawScope) {
        scope.drawLine(
            color = Color.Blue,
            start = start,
            end = end
        )
    }
}