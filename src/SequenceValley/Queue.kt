package SequenceValley

import java.util.LinkedList
import java.util.Queue

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val studentsQueue: Queue<Int> = LinkedList<Int>(students.toList())
    val sandwichesQueue: Queue<Int> = LinkedList(sandwiches.toList())
    var counter = 0
    while (counter < studentsQueue.size){
        if (studentsQueue.first() == sandwichesQueue.first()){
            studentsQueue.poll()
            sandwichesQueue.poll()
            counter = 0
        }else{
            studentsQueue.add(studentsQueue.poll())
            counter ++
        }
    }
    return studentsQueue.size
}