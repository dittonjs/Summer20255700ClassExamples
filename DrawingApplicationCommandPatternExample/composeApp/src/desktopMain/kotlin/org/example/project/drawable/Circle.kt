package org.example.project.drawable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

data class Circle(val center: Offset, val radius: Float): Drawable() {
    override fun draw(scope: DrawScope) {
        scope.drawCircle(
            color = Color.Blue,
            radius = radius,
            center = center
        )
    }
}