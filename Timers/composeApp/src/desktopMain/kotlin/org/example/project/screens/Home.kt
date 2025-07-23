package org.example.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.example.project.Destinations
import org.example.project.MyScope
import org.example.project.Navigation
import kotlin.concurrent.thread




suspend fun doWork() {
    withContext(Dispatchers.IO) {
        while (true) {
            println("Working...")
            delay(1000)
        }
    }
}





// uses language agnostic dependency injection
@Composable
fun Home (navigation: Navigation) {
    var running by remember { mutableStateOf(false) }

    var scope = rememberCoroutineScope()

    LaunchedEffect(running) {
//        if (running) {
            scope.launch {
                doWork()
            }
//        }
    }

    Column {


        Text("Home Page")
        Button(onClick = {
            navigation.goToSettings()
        }) {
            Text("Settings")
        }

        Button(onClick = { running = !running}) {
            Text(if(running) "Stop" else "Start")
        }
    }
}

