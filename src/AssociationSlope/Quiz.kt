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
fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val remIndex = mutableMapOf<Int, Int>()
    remIndex[0] = -1
    var prefixSum = 0
    for (i in nums.indices){
        prefixSum += nums[i]
        val rem = prefixSum % k
        if (remIndex.contains(rem)){
            if (i - remIndex[rem]!! >= 2)
                return true
        }else{
            remIndex[rem] = i
        }
    }
    return false
}