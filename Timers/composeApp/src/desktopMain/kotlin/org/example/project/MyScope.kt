package org.example.project

import androidx.compose.runtime.RememberObserver
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.job
import kotlin.coroutines.CoroutineContext

class MyScope(
) : CoroutineScope, RememberObserver {
    override val coroutineContext = Dispatchers.Default
    override fun onRemembered() {
        this.coroutineContext.job
        TODO("Not yet implemented")
    }

    override fun onForgotten() {
        TODO("Not yet implemented")
    }

    override fun onAbandoned() {
        TODO("Not yet implemented")
    }


}