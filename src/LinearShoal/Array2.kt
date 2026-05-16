package LinearShoal

import kotlin.math.abs

fun findErrorNums(nums: IntArray): IntArray {
    val sortedNums = nums.sortedArray()
    val ans = IntArray(2)




    fun findMissing(nums: Set<Int>): Int {
        var c = 1
        for (i in nums) {
            if (i != c)
                return c;
            c++
        }
        return c;
    }

    fun findDublicate(nums: IntArray): Int {

        for (i in 1..nums.size - 1) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }
        return 0;
    }

    ans[0] = findDublicate(sortedNums)
    ans[1] = findMissing(sortedNums.toSet())
    return ans
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val ans = arrayListOf<Int>()
    for (i in nums.indices){
        val index = abs(nums[i])-1
        if (nums[index]>0)
            nums[index] = -nums[index]
    }
    for (i in nums.indices){
        if (nums[i]>0)
            ans.add(i+1)
    }
    return ans
}

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    for(i in 0..nums.size-1){
        var value = 0
        for(j in 0..nums.size-1){
            if(i == j)
                continue
            if(nums[i]> nums[j])
                value++
        }
        ans[i] = value

    }
    return ans
}