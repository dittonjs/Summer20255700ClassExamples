class PepperoniRyeSandwich: SandwichTemplate() {
    override fun bottomBread() {
        println("Rye on the bottom")
    }

    override fun condiments() {
        println("olive oil down")
    }

    override fun meat() {
        println("pepperoni put down")
    }

    override fun veggies() {
        println("More pepperoni, cuz we eat meat in this house")
    }

    override fun topBread() {
        println("More rye")
    }
}