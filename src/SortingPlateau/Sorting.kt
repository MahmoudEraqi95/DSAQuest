package SortingPlateau

fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    var minDif = Int.MAX_VALUE
    val prefixDif = IntArray(arr.size)
    prefixDif[0] = minDif
    arr.sort()
    for (i in 0..arr.size - 2) {
        val dif = arr[i + 1] - arr[i]
        if (dif < minDif) {
            minDif = dif
        }
        prefixDif[i + 1] = dif
    }
    for (i in 0..arr.size - 2) {
        if (prefixDif[i + 1] == minDif) {
            result.add(arrayListOf(arr[i], arr[i + 1]))
        }
    }
    return result

}