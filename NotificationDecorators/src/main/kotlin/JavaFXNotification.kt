class JavaFXNotification: Notification() {
    override fun send(message: String) {
        println("I am sending message $message to the JavaFX UI")
    }
}