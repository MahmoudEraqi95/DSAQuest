package SortingPlateau

fun findRightInterval(intervals: Array<IntArray>): IntArray {
    val result = IntArray(intervals.size)
    result.fill(-1)
    for (i in intervals.indices){
        val current = intervals[i]
        var minJ = Int.MAX_VALUE
        for (j in intervals.indices){

            if (current[1] <= intervals[j][0] && intervals[j][0]<minJ) {
                result[i] = j
                minJ = intervals[j][0]
                //println("I is $i J is $j result[i] is ${result[i]}")
            }
        }
    }
    return result
}