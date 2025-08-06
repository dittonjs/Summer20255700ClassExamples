fun main() {
    val names = mutableListOf("Joseph", "Catelyn", "Sophie", "Rowan")
    val course = CollegeCourse()
    course.forEach {
        println(it)
    }
    printAll(names.iterator())
    printAll(course)
}

fun <T> printAll(iterator: Iterator<T>) {
    while(iterator.hasNext()) {
        println(iterator.next())
    }
}


class CollegeCourse: Iterator<String> {
    private val students = mutableListOf("Student 1", "Student 2", "Student 3")
    val studentIterator = students.iterator()

    override fun next() = studentIterator.next().uppercase() + " In course XXX"

    override fun hasNext() = studentIterator.hasNext()
}