class SlackDecorator(notification: Notification): NotificationDecorator(notification) {
    override fun send(message: String) {
        println("Sending $message as Slack Notification")
        notification.send(message)
    }
}