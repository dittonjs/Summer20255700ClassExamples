package org.example.project.drawing.commands

import androidx.compose.ui.geometry.Offset
import org.example.project.drawable.Circle
import org.example.project.drawable.Drawable
import org.example.project.drawable.drawableFactory
import org.example.project.drawing.Drawing

class DrawCircleCommand(drawing: Drawing): DrawingCommand(drawing) {
    private lateinit var circle: Circle
    override fun mouseDown(offset: Offset) {
        circle = drawableFactory(Drawable.Type.CIRCLE, offset) as Circle
        drawing.addDrawable(circle)
    }

    override fun mouseMove(offset: Offset) {
        val old = circle
        circle = old.copy(
            radius = old.radius + offset.x
        )
        drawing.updateDrawable(old, circle)
    }

    override fun undo() {
        drawing.removeDrawable(circle)
    }

    override fun redo() {
        drawing.addDrawable(circle)
    }

    override fun copy() = commandFactory(Type.CIRCLE, drawing)

}