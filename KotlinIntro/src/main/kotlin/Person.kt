class Person(var name: String?, val age: Int = 10, val jobId: Int? = null) {
    private val _accounts: MutableList<Account> = mutableListOf()

    val accounts: List<Account>
        get(){
            println(_accounts.toList() === _accounts)
            return _accounts.toList()
        }


    fun addAccount(account: Account) {
        println("Make sure that account is valid")
        _accounts.add(account)
    }
}