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