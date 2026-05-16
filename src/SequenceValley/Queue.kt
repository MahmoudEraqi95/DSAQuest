package SequenceValley

import java.util.LinkedList
import java.util.Queue

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val studentsQueue: Queue<Int> = LinkedList<Int>(students.toList())
    val sandwichesQueue: Queue<Int> = LinkedList(sandwiches.toList())
    var counter = 0
    while (counter < studentsQueue.size) {
        if (studentsQueue.first() == sandwichesQueue.first()) {
            studentsQueue.poll()
            sandwichesQueue.poll()
            counter = 0
        } else {
            studentsQueue.add(studentsQueue.poll())
            counter++
        }
    }
    return studentsQueue.size
}

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {

    val ticketsQueue = LinkedList(tickets.toList())
    var counter = 0
    var indexOfK = k
    var kValue = tickets[k]
    while (kValue > 0) {

        val firstInQueue = ticketsQueue.first()

        if (indexOfK == 0 && kValue == 1){
            counter++
            return counter
        }
        else if (indexOfK == 0) {
            ticketsQueue.poll()
            kValue--
            ticketsQueue.add(kValue)
            indexOfK = ticketsQueue.size -1

        }
        else if (firstInQueue == 1){
            ticketsQueue.poll()
            indexOfK--
        }
        else {
            ticketsQueue.poll()
            ticketsQueue.add(firstInQueue-1)
            indexOfK--
        }
        counter++
    }
    return counter
}