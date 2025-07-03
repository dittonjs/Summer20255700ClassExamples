abstract class Account(

    val balance: Double,
    val accountNumber: Long,
) {

    protected val interestRate: Float = 0f

    fun withdraw(amount: Double) {
        println("Withdraw called")
    }

    abstract fun applyInterest()
}