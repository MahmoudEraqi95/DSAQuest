package SequenceValley

import java.util.PriorityQueue
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