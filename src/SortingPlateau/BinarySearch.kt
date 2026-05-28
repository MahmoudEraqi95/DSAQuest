package SortingPlateau

fun peakIndexInMountainArray(arr: IntArray): Int {
    fun binarySearch(left: Int, right: Int): Int {
        var mid = (left + right) / 2
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
            return mid
        if (arr[mid]>arr[mid-1]){
            return binarySearch(mid, right)
        }else{
            return binarySearch(left, mid)
        }
        return -1 //shouldn't happen
    }
    return binarySearch(0, arr.size-1)

}
