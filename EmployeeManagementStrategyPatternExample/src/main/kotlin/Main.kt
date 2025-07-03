

fun main() {
    val employees = generateEmployees()
    
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