package romannumerals

fun decode(romanNumeral: String): Int {
    var result = 0
    var previousNumber = 0

    romanNumeral.reversed().forEach { numeral ->
        val currentNumber = parse(numeral)
        result = updateResult(currentNumber, previousNumber, result)
        previousNumber = currentNumber
    }
    return result
}

fun parse(numeral: Char) = when(numeral){
    'I' -> 1
    'V' -> 5
    'X' -> 10
    'L' -> 50
    'C' -> 100
    'D' -> 500
    'M' -> 1000
    else -> 0
}

fun updateResult(currentNumber: Int, previousNumber: Int, result: Int): Int {
    return if (currentNumber >= previousNumber)
        result + currentNumber
    else
        result - currentNumber
}