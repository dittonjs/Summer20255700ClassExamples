package org.example.project.drawable

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

data class Rectangle(val topLeft: Offset, var width: Float, var height: Float): Drawable() {
    override fun draw(scope: DrawScope) {
        scope.drawRect(
            color = Color.Blue,
            topLeft = topLeft,
            size = Size(width, height))
    }
}