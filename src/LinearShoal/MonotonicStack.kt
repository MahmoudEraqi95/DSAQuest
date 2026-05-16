package LinearShoal

import java.util.Stack

fun finalPrices(prices: IntArray): IntArray {

    val ans = prices.clone()
    val stack = Stack<Int>()
    for (i in prices.indices){
        while(stack.isNotEmpty()
            && prices[i]<=prices[stack.last()]){
            ans[stack.pop()] -=  prices[i]
        }
        stack.push(i)
    }
    return ans
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val ans = temperatures.clone()
    val isUpdated = BooleanArray(ans.size)
    val stack = Stack<Int>()
    for(i in temperatures.indices){

        while (stack.isNotEmpty() && temperatures[i]>temperatures[stack.last()]){
            ans[stack.last()] = i - stack.last()
            isUpdated[stack.pop()] = true
        }
        stack.add(i)
    }
    for (i in ans.indices){
        if (ans[i] == temperatures[i] && !isUpdated[i])
            ans[i] = 0
    }
    return ans
}

fun largestRectangleArea(heights: IntArray): Int {
    var max = 0
    val area = heights.clone() + 0
    val stack = Stack<Int>()
    for (i in heights.indices){

        while (stack.isNotEmpty() && area[stack.last()]> area[i]){
            val height = area[stack.pop()]
            val width = if (stack.isEmpty()){
                i
            }else{
                i -stack.size - 1
            }
            max = maxOf(max, height * width)
        }
        stack.push(i)

    }
    return max

}
