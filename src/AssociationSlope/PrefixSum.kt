package AssociationSlope

fun largestAltitude(gain: IntArray): Int {
    var current = 0
    var max = 0
    for (i in gain) {
        current += i
        if (current > max)
            max = current
    }
    return max
}

fun minSubarray(nums: IntArray, p: Int): Int {
    val totalRem = nums.map { it.toLong() }.sum() % p
    if (totalRem == 0L) return 0

    val lastSeen = HashMap<Long, Int>()
    lastSeen[0L] = -1

    var prefixRem = 0L
    var minLen = nums.size

    for (i in nums.indices) {
        prefixRem = (prefixRem + nums[i]) % p

        val target = (prefixRem - totalRem + p) % p
        lastSeen[target]?.let { j ->
            minLen = minOf(minLen, i - j)
        }

        lastSeen[prefixRem] = i
    }

    return if (minLen < nums.size) minLen else -1
}

fun waysToMakeFair(nums: IntArray): Int {

    var evenSum = nums.filterIndexed { i, e -> (i % 2) == 0 }.sum()
    var oddSum = nums.filterIndexed { i, e -> (i % 2) != 0 }.sum()
    var prefixEven = 0
    var prefixOdd = 0
    var result = 0
    for (i in nums.indices){
        var suffixEven = evenSum - prefixEven
        var suffixOdd = oddSum - prefixOdd

        if (i % 2 == 0){
            suffixEven -=  nums[i]
        }else{
            suffixOdd -= nums[i]
        }


        val evenSumWithoutCurrentNo = prefixEven + suffixOdd
        val oddWithoutCurrentNo = prefixOdd + suffixEven


        if (evenSumWithoutCurrentNo == oddWithoutCurrentNo)
            result++
        if (i % 2 == 0){
            prefixEven +=  nums[i]
        }else{
            prefixOdd += nums[i]
        }
    }
    return result
}