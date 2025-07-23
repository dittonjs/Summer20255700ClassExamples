package org.example.project.drawable

import androidx.compose.ui.geometry.Offset

fun drawableFactory(type: Drawable.Type, offset: Offset) = when(type) {
    Drawable.Type.CIRCLE -> Circle(offset, 0f)
    Drawable.Type.LINE -> Line(offset, offset.copy())
    Drawable.Type.RECTANGLE -> Rectangle(offset, 0f, 0f)
}