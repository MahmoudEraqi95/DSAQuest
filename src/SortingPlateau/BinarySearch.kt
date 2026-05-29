package SortingPlateau

import kotlin.math.sqrt


fun peakIndexInMountainArray(arr: IntArray): Int {
    fun binarySearch(left: Int, right: Int): Int {
        var mid = (left + right) / 2
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
            return mid
        if (arr[mid] > arr[mid - 1]) {
            return binarySearch(mid, right)
        } else {
            return binarySearch(left, mid)
        }
        return -1 //shouldn't happen
    }
    return binarySearch(0, arr.size - 1)

}

fun search(nums: IntArray, target: Int): Int {
    fun binarySearchWithTarget(left: Int, right: Int): Int {
        var mid = (left + right) / 2

        if (nums[mid] == target)
            return mid
        if (left == right || left > right)
            return -1
        if (nums[mid] < target) {

            return binarySearchWithTarget(mid+1, right)
        } else {

            return binarySearchWithTarget(left, mid-1)
        }
        return -1 //shouldn't happen
    }
    return binarySearchWithTarget(0, nums.size - 1)
}
fun judgeSquareSum(c: Int): Boolean {

    var right = sqrt(c.toDouble()).toLong()
    var left = 1
    while (left>=right){
        val leftSquared = left * left
        val rightSquared = right* right
        val res = leftSquared + rightSquared
        if (res == c.toLong())
            return true
        if (res > c.toDouble()){
            left--
        }else{
            right++
        }
    }
    return false

}
