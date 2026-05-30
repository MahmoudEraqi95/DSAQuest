package SortingPlateau

fun beautifulArray(n: Int): IntArray {

    fun build(n: Int): List<Int>{
        if (n == 1 )
            return listOf(1)
        val result = mutableListOf<Int>()
        for (i in build((n+1)/2)){
            result.add(2 * i -1)
        }
        for (i in build((n/2))){
            result.add(2 * i)
        }
        return result
    }
    return build(n).toIntArray()

}