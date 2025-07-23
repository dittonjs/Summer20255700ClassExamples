package org.example.project.drawing.commands

import org.example.project.drawing.Drawing

fun commandFactory(type: DrawingCommand.Type, drawing: Drawing) = when(type) {
    DrawingCommand.Type.RECTANGLE -> DrawRectangleCommand(drawing)
    DrawingCommand.Type.CIRCLE -> DrawCircleCommand(drawing)
    DrawingCommand.Type.LINE -> DrawLineCommand(drawing)
    DrawingCommand.Type.NOOP -> NoopCommand(drawing)
}