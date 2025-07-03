import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlin.text.get

private var ID_COUNTER = 1

@Serializable
data class RegisterBody(val name: String)


//'timestamp': datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
//'temperature': round(self.current_temperature, 1),
//'humidity': round(self.current_humidity, 1),
//'wind_speed': round(self.current_wind_speed, 1)
@Serializable
data class UpdateBody(val timestamp: String, val temperature: Double, val humidity: Double, val wind_speed: Double)

data class RegisterResponse(val id: Int)

fun server(application: Application) = application.launch {
    embeddedServer(Netty, 8000) {
        install(ContentNegotiation) {
            json()
        }

        routing {
            post("/register"){
                val data = call.receive<RegisterBody>()
                application.registerWeatherStation(data.name, ID_COUNTER)
                call.respondText("${ID_COUNTER++}", status = HttpStatusCode.OK)
            }

            post("/deregister/{id}") {
                application.deregisterWeatherStation(call.parameters["id"]?.toInt()?:-1)
                call.respondText("Success", status = HttpStatusCode.OK)
            }

            post("/update/{id}") {
                val data = call.receive<UpdateBody>()
                application.updateWeatherStation(
                    id = call.parameters["id"]?.toInt() ?: -1,
                    temp = data.temperature,
                    humidity = data.humidity,
                    windSpeed = data.wind_speed,
                    timeStamp=data.timestamp
                )
                call.respondText("Success", status = HttpStatusCode.OK)
            }
        }
    }.start(wait = true)
}




