package AssociationSlope

fun nextLargerNodes(head: ListNode?): IntArray {
    var newHead = head
    var n = 0
    while (newHead !=null){
        n++
        newHead = newHead.next
    }
    newHead = head
    val result = IntArray(n)
    var i = 0
    while (newHead != null){
        var currentNode = newHead
        currentNode = currentNode.next
        while (currentNode != null){
            if (currentNode.`val` > newHead.`val`){
                result[i] = currentNode.`val`
                break
            }
            currentNode = currentNode.next
        }
        newHead = newHead.next
        i++
    }
    return result

}
//fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
//
//}