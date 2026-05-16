package LinearShoal

import java.util.Stack
import java.util.stream.Gatherer

fun buildArray(target: IntArray, n: Int): List<String> {
    var counter = 1
    val ans = arrayListOf<String>()
    val stack = Stack<Int>()
    for (i in 1..n) {

        if (stack.toIntArray().contentEquals(target))
            return ans
        if (target.contains(i)) {
            ans.add("Push")
            stack.push(i)
        } else {
            ans.add("Push")
            ans.add("Pop")
        }

    }
    return ans
}

fun evalRPN(tokens: Array<String>): Int {
    val tokensArrayList = tokens.toMutableList()
    val stack = Stack<Int>()
    for (i in tokens){
        when (i) {
            "-" -> {
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 - op1)
            }
            "/" -> {
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 / op1)
            }
            "*" -> {
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 * op1)
            }
            "+" -> {
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 + op1)
            }
            else ->{
                stack.push(i.toInt())
            }
        }
    }
    return stack.pop()
}

fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    val stack = Stack<Int>()
    val ans = IntArray(n)
    var currentTime = 0
    for ( i in logs){
        val parts = i.split(":")
        val funID = parts[0].toInt()
        val process = parts[1]
        val time = parts[2].toInt()

        if (process == "start"){
            if (stack.isNotEmpty()) {
                ans[stack.last()] += time - currentTime
            }
            stack.push(funID)
            currentTime = time;
        }else{
            ans[stack.removeLast()] += time - currentTime +1
            currentTime = time+1
        }
    }
    return ans
}

