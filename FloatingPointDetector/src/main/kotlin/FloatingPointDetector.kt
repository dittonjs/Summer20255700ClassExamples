

fun isValidFloatingPointNumber(string: String): Boolean {


    var state: State = FirstDigitState()
    for (letter in string) {
        state = state.consumeLetter(letter.toString())
    }
    return state is ValidState
}

