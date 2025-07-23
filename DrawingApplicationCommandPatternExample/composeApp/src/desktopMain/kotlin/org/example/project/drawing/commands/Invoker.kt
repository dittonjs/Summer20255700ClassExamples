package org.example.project.drawing.commands

import androidx.compose.ui.geometry.Offset
import org.example.project.drawing.Drawing

class Invoker(private var command: DrawingCommand) {
    private val undoStack = mutableListOf<DrawingCommand>()
    private val redoStack = mutableListOf<DrawingCommand>()

    fun setCommand(type: DrawingCommand.Type, drawing: Drawing) {
        this.command = commandFactory(type, drawing)
    }

    fun onMouseDown(offset: Offset) {
        command.mouseDown(offset)
    }

    fun onMouseMove(offset: Offset) {
        command.mouseMove(offset)
    }

    fun onMouseUp() {
        if (command !is NoopCommand) {
            undoStack += command
            redoStack.clear()
            command = command.copy()
        }

    }

    fun onUndoClick() {
        val command = undoStack.removeLastOrNull()
        command?.apply {
            undo()
            redoStack += this
        }
    }

    fun onRedoClick() {
        val command = redoStack.removeLastOrNull()
        command?.apply {
            redo()
            undoStack += this
        }
    }
}