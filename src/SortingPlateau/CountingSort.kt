package SortingPlateau

import java.util.PriorityQueue

fun findKthLargest(nums: IntArray, k: Int): Int {
    var max = nums.max()
    var min = nums.min()
    val sorted = IntArray(max - min +1)
    for (i in nums){
        sorted[i - min]++
    }
    var rem = k
    for (i in sorted.indices.reversed()){
        rem -= sorted[i]
        if (rem <= 0)
            return i+min
    }
    return -1
}

fun sortArray(nums: IntArray): IntArray {
    val pq = PriorityQueue<Int>(nums.toList())
    val result = IntArray(nums.size)
    var i = 0
    while (pq.isNotEmpty()){
        result[i] = pq.poll()
        i++
    }
    return result
}