fun main() {
//    val person = Person("Joseph")
//    val savingsAccount = SavingsAccount(4.5f)
//    person.addAccount(savingsAccount)
//
//    (person.accounts.toMutableList()).add(SavingsAccount(5.6f))
//
//    for (account in person.accounts) {
//        println("Person ${person.name} has account with id ${account.accountNumber}")
//    }
    displayDuck(Mallard())
    displayDuck(RubberDuckiegh())

}

fun displayDuck(duck: Duck) {
    duck.quack()
    duck.fly()
}




fun doMath(a: Int, b: Int) = a + b