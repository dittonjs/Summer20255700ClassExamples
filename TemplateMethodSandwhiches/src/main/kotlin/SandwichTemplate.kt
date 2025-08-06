abstract class SandwichTemplate {
    fun makeSandwich() {
        bottomBread()

        condiments()

        meat()

        others()

        veggies()

        topBread()
    }

    protected abstract fun bottomBread()
    protected abstract fun condiments()
    protected abstract fun meat()
    protected abstract fun veggies()
    protected abstract fun topBread()
    protected open fun others() {}
}