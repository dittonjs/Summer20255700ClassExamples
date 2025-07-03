abstract class Duck {
    protected abstract val flyStrategy: FlyStrategy

    fun fly() {
        flyStrategy.perform()
    }

    fun quack() {
        println("I am a duck!!!!!!")
    }
}