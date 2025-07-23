class SMSDecorator(notification: Notification): NotificationDecorator(notification) {
    override fun send(message: String) {
        println("Sending $message as SMS")
        notification.send(message)
    }
}