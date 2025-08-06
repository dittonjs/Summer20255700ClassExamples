class FirstDigitState: State {
    override fun consumeLetter(letter: String) =
        when (letter) {
            "0" -> ZeroDigitState()
            in NON_ZERO_DIGITS -> HasDigitsState()
            "." -> HasPeriodState()
            else -> InvalidState()
        }
}