class EmailDecorator(notification: Notification): NotificationDecorator(notification) {
    override fun send(message: String) {
        println("Sending $message as an Email")
        notification.send(message)
    }
}