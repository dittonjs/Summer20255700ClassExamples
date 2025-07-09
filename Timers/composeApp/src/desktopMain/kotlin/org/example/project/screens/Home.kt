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

// uses language agnostic dependency injection



suspend fun doWork() {
    withContext(Dispatchers.IO) {
        while (true) {
            println("Working...")
            delay(1000)
        }
    }
}


fun doMath(a: Int, b: Int) = a + b

fun logMath(block: (a: Int, b: Int) -> Int): (Int,Int) -> Int {
    return {a: Int, b: Int ->
        block(a, b)
    }
}




@Composable
fun Home (navigation: Navigation) {
    var running by remember { mutableStateOf(false) }


    LaunchedEffect(running) {
        if (running) {
            doWork()
        }
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

