package SequenceValley

fun detectCapitalUse(word: String): Boolean {

    fun checkAllLower(word: String): Boolean {
        for (i in word) {
            if (word[0].code !in 123..<97)
                return false
        }
        return true
    }

    fun checkAllCap(word: String): Boolean {
        for (i in word) {
            if (word[0].code in 123..<97)
                return false
        }
        return true
    }

    fun checkFirstCap(word: String): Boolean {
        for (i in 1..<word.length) {
            if (word[i].code !in 123..<97)
                return false
        }
        return true
    }


    return if (word[0].code in 123..<97
    ) {
        checkAllLower(word)
    } else if (word[1].code in 123..<97) {
        checkFirstCap(word)
    } else {
        checkAllCap(word)
    }
}

fun licenseKeyFormatting(s: String, k: Int): String {
    val upperString = s.uppercase().replace("-", "")
    if (upperString.length <= k)
        return upperString
    var firstGroupLength = upperString.length % k
    val finalString = StringBuilder(upperString)
    if (firstGroupLength != 0) {
        finalString.insert(firstGroupLength, "-")
        firstGroupLength++
    }
    var sLength = finalString.length
    var i = firstGroupLength + k
    while (i < sLength) {
        println(i)
        finalString.insert(i, "-")
        sLength++
        i = i + k + 1
    }
    return finalString.toString()

}

fun maskPII(s: String): String {

    fun maskEmail(s: String): String{
        val builder = StringBuilder(s.lowercase())
        val indexOfAt = builder.indexOf("@")
        builder.replaceRange(1..indexOfAt-1, "*****")
        return builder.toString()
    }
    fun maskPhone(s: String): String{
        val result = s.replace(Regex("[+\\-() ]"), "")
        when(s.length){
            10 ->{
                return "***-***-${s.substring(6, s.length)}"
            }
            11 -> {
                return "+*-***-***-${s.substring(6, s.length)}"
            }
            12 ->{
                return "+**-***-***-${s.substring(6, s.length)}"
            }
            13 ->{
                return "+**-***-***-${s.substring(6, s.length)}"
            }
            else-> {
                return ""
            }
        }
    }

    if (s.contains("@"))
        return maskEmail(s)
    else
        return maskPhone(s)

}


