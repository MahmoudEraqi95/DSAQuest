package SortingPlateau

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if (nums1.isEmpty() || nums2.isEmpty())
        return
    val temp = IntArray((m + n))
    var pt1 = 0
    var pt2 = 0
    var pt3 = 0
    while (pt3 < m + n) {
        //   println("nums $pt1 ${nums1[pt1]} nums2 $pt2 ${nums2[pt2]} ")
        //println("$pt1 $pt2")
        if (pt1 >= m) {
            temp[pt3++] = nums2[pt2++]
            continue
        }
        if (pt2 >= n) {
            temp[pt3++] = nums1[pt1++]
            continue
        }
        if (nums1[pt1] < nums2[pt2]) {
            temp[pt3++] = nums1[pt1++]
        } else {
            temp[pt3++] = nums2[pt2++]
        }
    }
    for (i in temp.indices) {
        //   println("Temp $i ${temp[i]}")
        nums1[i] = temp[i]
    }

}
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
