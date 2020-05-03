package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        //throw NotImplementedError("Not implemented")

        if(number.toInt() < 0) return null

        val stroka = StringBuilder(number)
        val resultList = mutableListOf<String>()
        for((index, cifr) in stroka.withIndex()){
            val neighborsArray = Result(cifr)
            for(i in neighborsArray){
                stroka[index] = i
                resultList.add(stroka.toString())
                stroka[index] = cifr
            }
        }
        return resultList.toTypedArray()
    }

    private fun Result(cifr : Char) : Array<Char> {
        return when (cifr) {
            '1' -> arrayOf('4', '2')
            '2' -> arrayOf('1', '3', '5')
            '3' -> arrayOf('2', '6')
            '4' -> arrayOf('1', '5', '7')
            '5' -> arrayOf('2', '4', '6', '8')
            '6' -> arrayOf('3', '5', '9')
            '7' -> arrayOf('4', '8')
            '8' -> arrayOf('0', '5', '7', '9')
            '9' -> arrayOf('6', '8')
            '0' -> arrayOf('8')
            else -> arrayOf(' ')
        }
    }
}
