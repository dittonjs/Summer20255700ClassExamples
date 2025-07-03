interface FlyStrategy {
    fun perform()
}

class WingedFlightStrategy(): FlyStrategy {
    override fun perform() {
        println("Im flyin!!!!")
    }
}

class NoFlightStrategy(): FlyStrategy {
    override fun perform() {
        // noop
    }
}