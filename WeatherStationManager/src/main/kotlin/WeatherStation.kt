class WeatherStation(val name: String, val id: Int): Subject<WeatherStationObserver> {
    var temp: Double = 0.0
    var windSpeed: Double = 0.0
    var humidity: Double = 0.0
    var timeStamp: String = ""
        set(value) {
            field = value
            notifyObservers()
        }

    private val observers = mutableListOf<WeatherStationObserver>()

    override fun subscribe(observer: WeatherStationObserver) {
        observers += observer
    }

    override fun unsubscribe(observer: WeatherStationObserver) {
        observers -= observer
    }

    override fun notifyObservers() {
        observers.forEach { it.update(this) }
    }
}

