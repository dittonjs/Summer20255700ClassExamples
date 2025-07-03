import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class Application() : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private val commandLineDisplay = CommandLineDisplay()

    init {
        server(this)
        println("Server started")
    }

    private val _weatherStations = mutableMapOf<Int,WeatherStation>()

    val weatherStations: Map<Int, WeatherStation>
        get() = _weatherStations.toMap()

    fun registerWeatherStation(name: String, id: Int) {
        val weatherStation = WeatherStation(name, id)
        _weatherStations[id] = weatherStation
    }

    fun deregisterWeatherStation(id: Int) {
        _weatherStations.remove(id)
    }

    fun updateWeatherStation(id: Int, temp: Double, humidity: Double, windSpeed: Double, timeStamp: String) {
        val station = _weatherStations[id]
        station?.temp = temp
        station?.humidity = humidity
        station?.windSpeed = windSpeed
        station?.timeStamp = timeStamp
        if (station != null) {
            commandLineDisplay.update(
                temp = station.temp,
                humidity = station.humidity,
                windSpeed=station.windSpeed,
                timeStamp = station.timeStamp,
                name=station.name
            )
        }
    }

}