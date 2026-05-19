package AssociationSlope

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    val start = ListNode(0)
    var newHead = head
    start.next = newHead
    while (newHead?.next != null){
        if (newHead?.next!!.`val` == newHead.`val`){
            newHead.next = newHead.next!!.next
        }else{
            newHead = newHead.next
        }
    }
    return start.next
}