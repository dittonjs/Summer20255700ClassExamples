interface SerializableStrategy {
    fun serialize(employees: List<Employee>): String
}