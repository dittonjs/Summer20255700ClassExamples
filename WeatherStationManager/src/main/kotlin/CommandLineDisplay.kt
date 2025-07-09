class CommandLineDisplay: WeatherStationObserver {
    override fun update(weatherStation: WeatherStation) {
        println("========== Weather for ${weatherStation.name} ===============")
        println("TimeStamp: ${weatherStation.timeStamp}")
        println("Temp: ${weatherStation.temp}")
        println("Humidity: ${weatherStation.humidity}")
        println("Wind Speed: ${weatherStation.windSpeed}")
    }

}