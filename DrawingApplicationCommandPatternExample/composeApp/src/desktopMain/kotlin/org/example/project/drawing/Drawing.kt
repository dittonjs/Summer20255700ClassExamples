package org.example.project.drawing

import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.drawable.Drawable

class Drawing {
    private val drawables = MutableStateFlow<MutableList<Drawable>>(mutableListOf())


    fun addDrawable(drawable: Drawable) {
        drawables.update {
            it += drawable
            it.toMutableList()
        }
    }

    fun updateDrawable(oldDrawable: Drawable, newDrawable: Drawable) {
        drawables.value[drawables.value.indexOf(oldDrawable)] = newDrawable
        drawables.value = drawables.value.toMutableList()
    }

    fun removeDrawable(drawable: Drawable) {
        drawables.value -= drawable
        drawables.value = drawables.value.toMutableList()
    }
}