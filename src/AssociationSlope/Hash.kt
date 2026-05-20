package AssociationSlope
 class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
     }

fun twoSum(nums: IntArray, target: Int): IntArray {
    for( i in nums.indices){
        for( j in nums.indices) {
            if (j <= i)
                continue
            if (nums[i] + nums[j] == target)
                return intArrayOf(i, j)
        }

    }
    return intArrayOf()
}

fun twoSumUsingHashMap(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for(i in nums.indices){
        val comp = target-nums[i]
        if(map.containsKey(comp))
            return intArrayOf(i, map[comp]!!)
        map[nums[i]] = i

    }
    return intArrayOf()
}

fun copyRandomList(node: Node?): Node? {
    var newHead = node
    val map = mutableMapOf<Node, Node>()

    while (newHead != null){
        map[newHead] = Node(newHead.`val`)
        newHead = newHead.next
    }
    newHead = node
    while (newHead != null){
        val current = map[newHead]
        current?.random = map[newHead.random]
        current?.next = map[newHead.next]
        newHead = newHead.next
    }
    return map[node]

}

fun firstMissingPositive(nums: IntArray): Int {
    val set = HashSet<Int>(nums.toSet())
    for(i in 1..set.size+1)
        if (!set.contains(i))
            return i
    return -1
}
fun firstMissingPositiveSmartSolution(nums: IntArray): Int {
    for (i in nums.indices){
        if (nums[i] in 1..nums.size-1 && nums[i] != nums[nums[i] -1]){
            val rightIndex = nums[i] -1
            val temp = nums[i]
            nums[i] = nums[rightIndex]
            nums[rightIndex] = temp

        }
    }
    for(i in nums.indices){
        if (nums[i] != i + 1)
            return i+1
    }
    return nums.size+1
}