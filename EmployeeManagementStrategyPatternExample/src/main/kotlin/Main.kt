


private val STRATEGIES =
    mapOf(
        "csv" to CSVStrategy(),
        "json" to JSONStrategy(),
        "xml" to XMLStrategy()
    )


fun main() {
    val employees = generateEmployees()
    println("What format do you want the data (xml,json,csv):")
    val input = readln()
    println(STRATEGIES[input]?.serialize(employees) ?: "Invalid selection")

}

fun generateEmployees(): List<Employee> {
    val employees = mutableListOf<Employee>()
    for (i in 0 until 1000) {
        employees.add(Employee(
            id = i.toLong(),
            name = "Person $i",
            salary = 90000.0,
            jobTitle = "Worker"
        ))
    }
    return employees.toList()
}