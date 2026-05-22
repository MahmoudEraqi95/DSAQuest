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