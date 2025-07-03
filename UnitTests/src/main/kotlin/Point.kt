class Point (
    x: Double,
    y: Double   
){
    var x: Double = x
        private set
    var y: Double = y
        private set

    fun move(deltaX: Double, deltaY: Double) {
        if (deltaX.isInfinite() || deltaY.isInfinite()) {
            throw IllegalArgumentException("Values must be finite")
        }
        x += deltaX
        y += deltaY
    }
}