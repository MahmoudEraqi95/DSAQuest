package AssociationSlope

fun twoSum(nums: IntArray, target: Int): IntArray {
    for( i in nums.indices){
        for( j in nums.indices) {
            if (j <= i)
                continue
            if (nums[i] + nums[j] == target)
                return intArrayOf(i, j)
        }

    }
    return intArrayOf()
}

fun twoSumUsingHashMap(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for(i in nums.indices){
        val comp = target-nums[i]
        if(map.containsKey(comp))
            return intArrayOf(i, map[comp]!!)
        map[nums[i]] = i

    }
    return intArrayOf()
}