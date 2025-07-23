package org.example.project.drawing.commands

import androidx.compose.ui.geometry.Offset
import org.example.project.drawing.Drawing

class NoopCommand(drawing: Drawing): DrawingCommand(drawing) {
    override fun mouseDown(offset: Offset) {

    }

    override fun mouseMove(offset: Offset) {

    }

    override fun undo() {

    }

    override fun redo() {

    }

    override fun copy(): DrawingCommand {
        return this
    }
}