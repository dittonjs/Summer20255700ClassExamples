class ComposeNotification: Notification() {
    override fun send(message: String) {
        println("I am sending message $message to the compose UI")
    }
}