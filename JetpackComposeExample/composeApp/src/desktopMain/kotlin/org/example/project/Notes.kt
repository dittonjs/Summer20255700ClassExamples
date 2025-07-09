package org.example.project

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

data class Note(val content: String)

@Composable
fun Notes() {
    val notes = remember{ mutableStateListOf<Note>() }
    var noteContent by remember { mutableStateOf("") }
    Row{
        TextField(noteContent, onValueChange = {noteContent = it})
        Button(onClick = {
            notes += Note(noteContent)
            noteContent = ""
        }) {
            Text("Save")
        }
    }
    LazyColumn {
        items(notes) {
            Text(it.content)
        }
    }
}