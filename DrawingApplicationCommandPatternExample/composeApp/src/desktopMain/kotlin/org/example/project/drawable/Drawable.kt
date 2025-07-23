package org.example.project.drawable

import androidx.compose.ui.graphics.drawscope.DrawScope

abstract class Drawable {
    enum class Type {
        CIRCLE,
        LINE,
        RECTANGLE
    }
    abstract fun draw(scope: DrawScope)
}