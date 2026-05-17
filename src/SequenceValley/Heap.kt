package SequenceValley

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.min

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
