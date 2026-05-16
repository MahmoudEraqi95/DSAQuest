package LinearShoal

fun main() {

}

fun getConcatenation(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(2 * n)
    for (i in 0..(2 * n - 1)) {
        ans[i] = nums[i % n]
    }
    return ans
}

fun shuffle(nums: IntArray, n: Int): IntArray {
    val ans = IntArray(2 * n)
    var counter = 0
    for (i in 0..n - 1) {
        ans[counter] = nums[i]
        counter++
        ans[counter] = nums[n + i]
        counter++
    }
    return ans
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var max = 0
    var currentStreak = 0
    for (i in nums) {
        if (i == 0) {
            currentStreak = 0
            continue
        }
        if (i == 1)
            currentStreak++
        if (currentStreak > max)
            max = currentStreak

    }
    return max
}