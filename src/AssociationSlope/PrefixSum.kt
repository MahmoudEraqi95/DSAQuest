package AssociationSlope

fun largestAltitude(gain: IntArray): Int {
    var current = 0
    var max = 0
    for (i in gain){
        current += i
        if (current> max)
            max = current
    }
    return max
}