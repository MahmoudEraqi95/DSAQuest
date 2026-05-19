package AssociationSlope

import java.util.Stack

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    val start = ListNode(0)
    var newHead = head
    start.next = newHead
    while (newHead?.next != null) {
        if (newHead?.next!!.`val` == newHead.`val`) {
            newHead.next = newHead.next!!.next
        } else {
            newHead = newHead.next
        }
    }
    return start.next
}

fun oddEvenList(head: ListNode?): ListNode? {
    var oddList = ListNode(0)
    var newOddList = oddList
    var evenList = ListNode(0)
    var newEvenList = evenList
    var newHead = head
    while (newHead != null) {
        newOddList.next = newHead
        newOddList = newOddList.next!!
        if (newHead.next != null) {
            newEvenList.next = newHead.next
            newEvenList = newEvenList.next!!
            newHead = newHead.next?.next
        } else {
            break
        }
    }
    newEvenList.next = null
    newOddList.next = evenList.next
    return oddList.next
}

fun reverseList(head: ListNode?): ListNode? {
    var newHead = head
    val stack = Stack<Int>()
    while (newHead != null){
        stack.push(newHead.`val`)
        newHead = newHead.next
    }
    val newList = ListNode(0)
    var modifyingList = newList
    while (stack.isNotEmpty()){
        modifyingList.next = ListNode(stack.pop())
        modifyingList = modifyingList.next!!
    }
    return newList.next
}