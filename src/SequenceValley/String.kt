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

