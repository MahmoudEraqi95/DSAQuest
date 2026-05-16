import java.util.Stack

fun plusOne(digits: IntArray): IntArray {
    val n = digits.size
    if(digits[n-1] == 9){
        var c = n-1
        while(c > 0 && digits[c] == 9){
            digits[c] = 0
            c--

        }

        if(digits[c] == 9) {
            digits[c] = 1
            return digits + 0
        }
        else{
            digits[c] ++
            return digits
        }


    }

    digits[n-1] += 1
    return digits
}

fun validMountainArray(arr: IntArray): Boolean {
    if (arr.size<3)
        return false

    var p1 = 1
    while (p1<arr.size){
        if (arr[p1]>arr[p1-1]) {
            p1++
            continue

        }
        else if(arr[p1] == arr[p1-1])
            return false
        else{
            break
        }

    }
    if (p1>arr.size-2)
        return false

    while (p1 <arr.size-1){
        if (arr[p1]>arr[p1+1]) {
            p1++
            continue
        }
        else{
            return false
        }
    }
    return true

}
