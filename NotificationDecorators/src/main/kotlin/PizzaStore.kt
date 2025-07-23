abstract class PizzaStore {
    fun orderPizza(type: String) {
        // make the pizza
        // get payment
        // ...
    }

    abstract fun makePizza(type: String): Pizza
}

abstract class Pizza

class NYCheesePizza: Pizza()
class NYPepperoniPizza: Pizza()
class NYHamAndPinapplePizza: Pizza()
class ChicagoCheesePizza: Pizza()
class ChicagoPepperoniPizza: Pizza()
class ChicagoHamAndPinapplePizza: Pizza()

