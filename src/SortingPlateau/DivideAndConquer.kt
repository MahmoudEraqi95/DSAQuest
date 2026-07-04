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
    for(i in inorder.indices){
        inorderIndex[inorder[i]] = i
    }
    postOrderPointer = postorder.lastIndex
    return build(postorder, 0, inorder.lastIndex)
}
fun build(postorder: IntArray, leftIndex:Int, rightIndex:Int):TreeNode?{
    if(leftIndex>rightIndex){
        return null
    }
    val rootValue = postorder[postOrderPointer--]
    val rootNode = TreeNode(rootValue)
    val rootIndex = inorderIndex[rootValue]!!
    rootNode.right = build(postorder, rootIndex+1, rightIndex)
    rootNode.left = build(postorder, leftIndex, rootIndex-1)
    return rootNode;
}