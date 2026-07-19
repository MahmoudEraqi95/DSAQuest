package SortingPlateau

fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {

    if (m * k > bloomDay.size)
        return -1
    var left = bloomDay.min()
    var right = bloomDay.max()

    while (left < right) {
        val mid = left + (right - left) / 2
        if (binarySearch(mid, bloomDay, m, k)) {
            right = mid
        } else {
            left = mid +1
        }
    }
    return left

}

fun binarySearch(day: Int, bloomDay: IntArray, m: Int, k: Int): Boolean {

    var flowers = 0
    var bouqs = 0
    for (i in bloomDay) {

        if (i <= day) {
            flowers++
            if (flowers == k) {
                bouqs++
                if (bouqs == m)
                    return true
                flowers = 0
            }
        } else {
            flowers = 0
        }
    }
    return false
}