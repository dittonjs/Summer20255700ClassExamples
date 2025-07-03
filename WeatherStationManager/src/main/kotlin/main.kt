import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.cancellation.CancellationException

fun main() = runBlocking {
    Application()
    while(true) {
        println("Type in the id of the station")
        val input = readln()
//        TODO: implement this
    }
}

