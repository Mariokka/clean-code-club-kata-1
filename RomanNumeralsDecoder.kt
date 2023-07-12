package romannumerals

fun decode(romanNumeral: String): Int {
    val dictionary = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    return decodeUsingDictionary(romanNumeral, dictionary)
}

fun decodeUsingDictionary(romanNumeral: String, dictionary: Map<Char, Int>): Int {
    var result = 0
    var previousNumber = 0

    for (i in romanNumeral.indices.reversed()) {
        val currentNumber = extractNumberFromDictionary(i, dictionary, romanNumeral)
        result = updateResult(currentNumber, previousNumber, result)
        previousNumber = currentNumber
    }
    return result
}

fun extractNumberFromDictionary(i: Int, dictionary: Map<Char, Int>, romanNumeral: String) =
    dictionary[romanNumeral[i]] ?: 0

fun updateResult(currentValue: Int, previousValue: Int, result: Int): Int {
    var newResult = result
    if (currentValue >= previousValue)
        newResult += currentValue
    else
        newResult -= currentValue
    return newResult
}