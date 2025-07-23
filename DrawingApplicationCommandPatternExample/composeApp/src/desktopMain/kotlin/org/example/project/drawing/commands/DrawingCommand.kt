package org.example.project.drawing.commands

import androidx.compose.ui.geometry.Offset
import org.example.project.drawing.Drawing

abstract class DrawingCommand(protected val drawing: Drawing){

    enum class Type {
        RECTANGLE,
        CIRCLE,
        LINE,
        NOOP
    }

    abstract fun mouseDown(offset: Offset)
    abstract fun mouseMove(offset: Offset)
    abstract fun undo()
    abstract fun redo()
    abstract fun copy(): DrawingCommand
}