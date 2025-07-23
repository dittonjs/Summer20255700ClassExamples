package org.example.project.drawing.commands

import androidx.compose.ui.geometry.Offset
import org.example.project.drawable.Drawable
import org.example.project.drawable.Rectangle
import org.example.project.drawable.drawableFactory
import org.example.project.drawing.Drawing

class DrawRectangleCommand(drawing: Drawing): DrawingCommand(drawing) {
    private lateinit var rectangle: Rectangle
    override fun mouseDown(offset: Offset) {
        rectangle = drawableFactory(Drawable.Type.RECTANGLE, offset) as Rectangle
        drawing.addDrawable(rectangle)
    }

    override fun mouseMove(offset: Offset) {
        val old = rectangle
        rectangle = old.copy(
            width = old.width + offset.x,
            height = old.height + offset.y
        )
        drawing.updateDrawable(old, rectangle)
    }

    override fun undo() {
        drawing.removeDrawable(rectangle)
    }

    override fun redo() {
        drawing.addDrawable(rectangle)
    }

    override fun copy() = commandFactory(Type.RECTANGLE, drawing)

}