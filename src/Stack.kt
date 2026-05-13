import java.util.Stack

fun buildArray(target: IntArray, n: Int): List<String> {
    var counter = 1
    val ans = arrayListOf<String>()
    val stack = Stack<Int>()
    for (i in 1..n){

        if (stack.toIntArray().contentEquals(target))
            return ans
        if (target.contains(i)) {
            ans.add("Push")
            stack.push(i)
        }
        else{
            ans.add("Push")
            ans.add("Pop")
        }

    }
    return ans
}