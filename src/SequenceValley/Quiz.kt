package SequenceValley

import java.util.PriorityQueue
import java.util.Stack
import kotlin.math.min


fun eatenApples(apples: IntArray, days: IntArray): Int {

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    var day = 0
    var eaten = 0

    while (day < apples.size || pq.isNotEmpty()) {


        if (day < apples.size && apples[day] > 0) {
            pq.add(Pair(apples[day], day + days[day]))
        }


        while (pq.isNotEmpty() &&
            (pq.peek().second <= day || pq.peek().first == 0)
        ) {
            pq.poll()
        }


        if (pq.isNotEmpty()) {
            val (count, expire) = pq.poll()

            eaten++

            if (count > 1) {
                pq.add(Pair(count - 1, expire))
            }
        }

        day++
    }

    return eaten
}

class MyCircularQueue(k: Int) {

    private val queue = IntArray(k)
    private val capacity = k

    private var front = 0
    private var rear = -1
    private var size = 0

    fun enQueue(value: Int): Boolean {
        if (isFull()) return false

        rear = (rear + 1) % capacity
        queue[rear] = value
        size++

        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) return false

        front = (front + 1) % capacity
        size--

        return true
    }

    fun Front(): Int {
        return if (isEmpty()) -1 else queue[front]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else queue[rear]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == capacity
    }
}
