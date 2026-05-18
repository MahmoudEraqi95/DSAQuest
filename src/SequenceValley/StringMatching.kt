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
fun rotateString(s: String, goal: String): Boolean {
    val n = s.length
    var i = 0
    var newS = s
    while(i <n){
        newS += "${newS[0]}"
        newS = newS.substring(1,  n+1)


        if (newS == goal)
            return true
        i++
    }
    return false

}

fun repeatedStringMatch(a: String, b: String): Int {
    val minReps = (b.length + a.length - 1) / a.length

    for (reps in minReps..minReps + 1) {
        if (a.repeat(reps).contains(b)) return reps
    }

    return -1
}