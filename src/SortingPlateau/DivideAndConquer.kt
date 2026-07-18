package SortingPlateau

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun beautifulArray(n: Int): IntArray {

    fun build(n: Int): List<Int> {
        if (n == 1)
            return listOf(1)
        val result = mutableListOf<Int>()
        for (i in build((n + 1) / 2)) {
            result.add(2 * i - 1)
        }
        for (i in build((n / 2))) {
            result.add(2 * i)
        }
        return result
    }
    return build(n).toIntArray()

}

val inorderIndex = HashMap<Int, Int>()
var postOrderPointer: Int = 0
fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    for (i in inorder.indices) {
        inorderIndex[inorder[i]] = i
    }
    postOrderPointer = postorder.lastIndex
    return build(postorder, 0, inorder.lastIndex)
}

fun build(postorder: IntArray, leftIndex: Int, rightIndex: Int): TreeNode? {
    if (leftIndex > rightIndex) {
        return null
    }
    val rootValue = postorder[postOrderPointer--]
    val rootNode = TreeNode(rootValue)
    val rootIndex = inorderIndex[rootValue]!!
    rootNode.right = build(postorder, rootIndex + 1, rightIndex)
    rootNode.left = build(postorder, leftIndex, rootIndex - 1)
    return rootNode;
}

fun reversePairsWithTLE(nums: IntArray): Int {
    var result = 0
    for (i in nums.indices) {
        val currentI = nums[i]
        for (j in i + 1..nums.size - 1) {
            val doubleOfJ: Long = 2 * nums[j].toLong()
            if (currentI > doubleOfJ)
                result++
        }
    }
    return result
}

fun reversePairs(nums: IntArray): Int {
    return mergeSort(nums, 0, nums.size - 1)
}

private fun mergeSort(nums: IntArray, left: Int, right: Int): Int {
    if (left >= right) return 0

    val mid = left + (right - left) / 2

    var count = mergeSort(nums, left, mid)
    count += mergeSort(nums, mid + 1, right)

    var j = mid + 1
    for (i in left..mid) {
        while (j <= right && nums[i].toLong() > 2L * nums[j].toLong()) {
            j++
        }
        count += j - (mid + 1)
    }
    val temp = IntArray(right - left + 1)
    var i = left
    j = mid + 1
    var k = 0

    while (i <= mid && j <= right) {
        if (nums[i] <= nums[j]) {
            temp[k++] = nums[i++]
        } else {
            temp[k++] = nums[j++]
        }
    }

    while (i <= mid) {
        temp[k++] = nums[i++]
    }

    while (j <= right) {
        temp[k++] = nums[j++]
    }

    for (idx in temp.indices) {
        nums[left + idx] = temp[idx]
    }

    return count
}