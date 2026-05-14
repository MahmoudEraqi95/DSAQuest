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