package SequenceValley

fun repeatedSubstringPattern(s: String): Boolean {
    var currentIndex = 1
    val stringLength = s.length
    while (true){
        if (currentIndex > (s.length/2)){
            return false
        }
        val subString = s.substring(0, currentIndex)
        val subLength = subString.length
        if (stringLength % subLength != 0 ){
            currentIndex++
            continue

        }
        var newString = ""

        for (i in 0..stringLength-1 step subLength){

            newString += subString


        }
        if (newString == s)
            return true
        currentIndex++

    }
}