
// an idiomatic represention of the decorator pattern
//fun doMath(a: Int, b: Int) = a + b
//
//val doMoreMath = logMath { a, b ->
//    return@logMath a * b
//}
//
//fun logMath(block: (a: Int, b: Int) -> Int): (Int,Int) -> Int {
//    return {a: Int, b: Int ->
//        println("Math was called with $a, $b")
//        block(a, b)
//    }
//}
//
//
//
//val decoratedAdd = logMath(::doMath)

fun notificationFactory(type: String, extensions: Set<String> = setOf()): Notification {
    var notification = when (type) {
        "compose" -> ComposeNotification()
        "javafx" -> JavaFXNotification()
        else -> throw IllegalArgumentException("Invalid notification type")
    }
    for (extension in extensions) {
       notification = when(extension) {
           "sms" -> SMSDecorator(notification)
           "email" -> EmailDecorator(notification)
           "slack" -> SlackDecorator(notification)
           else -> notification
       }
    }
    return notification
}


fun main() {
    println("What UI are you using?")
    val ui = readln()
    println("What types of notifications do you want? (type 'done' when done):")
    val extensions = mutableSetOf<String>()

    while(true) {
        val input = readln()
        if (input == "done") break
        if (input in extensions) {
            extensions -= input
        } else {
            extensions += input
        }
    }

    val notification = notificationFactory(ui, extensions)
    Cache.cacheMyData()

    println("What message?:")
    notification.send(readln())
    Cache.cacheMyData()
}