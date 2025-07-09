package org.example.project

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class MyScope(
) : CoroutineScope {
    override val coroutineContext = Dispatchers.Default
}