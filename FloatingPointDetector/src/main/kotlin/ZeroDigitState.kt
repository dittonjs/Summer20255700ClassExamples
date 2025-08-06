class ZeroDigitState: State {
    override fun consumeLetter(letter: String) =
        when(letter) {
            "." -> HasPeriodState()
            else -> InvalidState()
        }
}