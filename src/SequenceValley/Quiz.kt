package SequenceValley

import java.util.PriorityQueue
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
