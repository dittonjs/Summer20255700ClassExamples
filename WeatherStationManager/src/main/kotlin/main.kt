import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val app = Application()
    val displays = mutableMapOf<String, WeatherStationObserver>()
    while(true) {
        println("Type in the id of the station")
        val input = readln()

        try {
            if (displays[input] != null) {
                app.weatherStations[input.toInt()]?.unsubscribe(displays[input] ?: CommandLineDisplay())
                displays.remove(input)
            } else {
                val display = CommandLineDisplay()
                app.weatherStations[input.toInt()]?.subscribe(display)
                app.weatherStations[input.toInt()]?.subscribe {
                    println("Holy cow, the wind is blowing ${it.windSpeed} fast!!!")
                }
                displays[input] = display
            }
        } catch (e: NumberFormatException) {
            println("Not a valid id")
        }
    }
}

