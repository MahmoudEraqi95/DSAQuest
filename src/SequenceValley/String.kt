package SequenceValley

fun detectCapitalUse(word: String): Boolean {

    fun checkAllLower(word: String): Boolean {
        for (i in word){
            if (word[0].code !in 123..<97)
                return false
        }
        return true
    }

    fun checkAllCap(word: String): Boolean {
        for (i in word){
            if (word[0].code in 123..<97)
                return false
        }
        return true
    }

    fun checkFirstCap(word: String): Boolean {
        for (i in 1..<word.length){
            if (word[i].code !in 123..<97)
                return false
        }
        return true
    }


    return if (word[0].code in 123..<97
    ) {
        checkAllLower(word)
    }
    else if(word[1].code in 123..<97){
        checkFirstCap(word)
    } else{
        checkAllCap(word)
    }
}
fun licenseKeyFormatting(s: String, k: Int): String {
    val upperString = s.uppercase().replace("-","")
    if(upperString.length<=k)
        return upperString
    var firstGroupLength = upperString.length % k
    val finalString = StringBuilder(upperString)
    if (firstGroupLength != 0){
        finalString.insert(firstGroupLength, "-")
        firstGroupLength++
    }
    var sLength = finalString.length
    var i = firstGroupLength+k
    while (i <sLength ){
        println(i)
        finalString.insert(i , "-")
        sLength ++
        i = i+k+1
    }
    return finalString.toString()

}

