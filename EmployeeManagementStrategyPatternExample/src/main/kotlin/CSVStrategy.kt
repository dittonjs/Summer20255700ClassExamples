class CSVStrategy: SerializableStrategy {
    override fun serialize(employees: List<Employee>): String {
        val builder: StringBuilder = StringBuilder()
        for (employee in employees) {
            builder.append("CSV for employee ${employee.id}")
        }
        return builder.toString()
    }
}