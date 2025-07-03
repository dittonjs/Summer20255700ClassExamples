class CommandLineDisplay {
    fun update(temp: Double, windSpeed: Double, humidity: Double, timeStamp: String, name: String) {
        println("========== Weather for $name ===============")
        println("TimeStamp: $timeStamp")
        println("Temp: $temp")
        println("Humidity: $humidity")
        println("Wind Speed: $windSpeed")
    }
}