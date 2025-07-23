package org.example.project.drawing.commands

import androidx.compose.ui.geometry.Offset
import org.example.project.drawable.Drawable
import org.example.project.drawable.Line
import org.example.project.drawable.drawableFactory
import org.example.project.drawing.Drawing

class DrawLineCommand(drawing: Drawing): DrawingCommand(drawing) {
    private lateinit var line: Line
    override fun mouseDown(offset: Offset) {
        line = drawableFactory(Drawable.Type.LINE, offset) as Line
        drawing.addDrawable(line)
    }

    override fun mouseMove(offset: Offset) {
        val old = line
        line = line.copy(
            end = old.end + offset
        )
        drawing.updateDrawable(old, line)
    }

    override fun undo() {
        drawing.removeDrawable(line)
    }

    override fun redo() {
        drawing.addDrawable(line)
    }

    override fun copy() = commandFactory(Type.LINE, drawing)

}