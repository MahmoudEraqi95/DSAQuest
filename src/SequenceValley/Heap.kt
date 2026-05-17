package SequenceValley

import java.util.PriorityQueue
import kotlin.comparisons.compareByDescending
import kotlin.math.abs

fun lastStoneWeight(stones: IntArray): Int {
    val heap = PriorityQueue<Int>(compareByDescending { it  })
    heap.addAll(stones.toList())
    while (heap.size > 1){
        val x = heap.poll()
        val y = heap.poll()
        if (x==y)
            continue
        else
            heap.add(abs(x-y))
    }
    if (heap.size == 1)
        return heap.poll()
    else
        return 0
}

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val minHeap = PriorityQueue<IntArray>(compareBy{it[0]})
    val ans = mutableListOf<List<Int>>()
    var kCopy = k
    for( i in 0..minOf(nums1.size-1, k)){
        minHeap.add(intArrayOf(nums1[i]+nums2[0], i, 0))
    }

    while (kCopy>0){
        val min = minHeap.poll()
        val i = min[1]
        val j = min[2]
        ans.add(listOf(nums1[i], nums2[j]))
        if ( j +1 <nums2.size)
            minHeap.add(intArrayOf(nums1[i] + nums2[j+1], i, j+1))
        kCopy--

    }
    return ans
}

fun isPossible(target: IntArray): Boolean {
    val maxHeap = PriorityQueue<Long>(compareByDescending { it } )
    maxHeap.addAll(target.toList().map { it.toLong() })
    var totalSum = 0L
    for (i in target){
        totalSum += i
    }
    val n = target.size

    while (true){
        val largest = maxHeap.poll()
        val remaining = totalSum - largest
        if (largest == 1L || remaining == 1L)
            return true

        if (remaining == 0L || largest < remaining || largest%remaining == 0L)
            return false
        val previous = largest - remaining
        totalSum = previous + remaining
        maxHeap.add(totalSum)
    }
}
