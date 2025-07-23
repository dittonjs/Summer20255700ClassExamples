package org.example.project.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.example.project.drawing.Drawing
import org.example.project.drawing.commands.DrawingCommand
import org.example.project.drawing.commands.Invoker
import org.example.project.drawing.commands.commandFactory

@Composable
fun rememberDrawing() = remember { Drawing() }

@Composable
fun rememberInvoker(drawing: Drawing) = remember { Invoker(commandFactory(DrawingCommand.Type.NOOP, drawing)) }

@Composable
@Preview
fun App() {
    MaterialTheme {
        val drawing = rememberDrawing()
        val invoker = rememberInvoker(drawing)


        Column {
            Row {
                Button(onClick = {
                    invoker.setCommand(DrawingCommand.Type.RECTANGLE, drawing)
                }) {
                    Text("Rectangle")
                }
                Button(onClick = {
                    invoker.setCommand(DrawingCommand.Type.CIRCLE, drawing)
                }) {
                    Text("Circle")
                }
                Button(onClick = {
                    invoker.setCommand(DrawingCommand.Type.LINE, drawing)
                }) {
                    Text("Line")
                }
                Button(onClick = {
                    invoker.onUndoClick()
                }) {
                    Text("Undo")
                }
                Button(onClick = {
                    invoker.onRedoClick()
                }) {
                    Text("Redo")
                }
            }
            Row {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .pointerInput(Unit) {

                            detectDragGestures(
                                onDragStart = {
                                    invoker.onMouseDown(it)
                                },
                                onDragEnd = {
                                    invoker.onMouseUp()

                                },
                                onDrag = {_, dragAmount ->
                                    invoker.onMouseMove(dragAmount)
                                }
                            )
                        }
                ) {

                    drawing.drawables.forEach {
                        it.draw(this)
                    }
                }
            }
        }
    }
}