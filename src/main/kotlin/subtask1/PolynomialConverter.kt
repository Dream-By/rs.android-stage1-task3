package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        var outputstring: String? = ""
        if (numbers.size == 0)
            outputstring = null
        else {
            for ((i, num) in numbers.withIndex()) {
                var outputsum: String = ""
                when (num) {
                    0 -> outputsum = ""
                    1 -> outputsum = " + x"
                    -1 -> outputsum = " - x"
                    else -> {
                        val alternate = if (num < 0) " - " else " + "

                        val level = if ((numbers.size - i - 1) == 0) ""
                        else if ((numbers.size - i - 1) == 1) "x"
                        else "x^${numbers.size - i - 1}"

                        outputsum = alternate + java.lang.Math.abs(num) + level
                    }
                }
                outputstring = outputstring + outputsum
            }
        }


        return  if (outputstring != null) outputstring.substring(3, outputstring.length)
        else
            outputstring

    }
}
