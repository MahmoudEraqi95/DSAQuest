package LinearShoal

import java.util.Stack

fun removeDuplicateLetters(s: String): String {
    val lastIndex = mutableMapOf<Char, Int>()
    val visited = mutableSetOf<Char>()
    for (i in s.indices){
        lastIndex[s[i]] = i
    }
    val stack = Stack<Char>()
    for(i in s.indices){
        val current = s[i]
        while (stack.isNotEmpty()
            && stack.last() > current
            && lastIndex[stack.last()]!! > i){
            visited.remove(stack.pop())
        }
        stack.push(current)
        visited.add(current)
    }
    return stack.joinToString()
}