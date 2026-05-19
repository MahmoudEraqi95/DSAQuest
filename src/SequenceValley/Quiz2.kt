package SequenceValley

fun reformatDate(date: String): String {
    val parts = date.split(" ")
    val year = parts[2]
    val month = parts[1]
    val day = parts[0]
    val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    var finalMonth = months.indexOf(month)+1
    var finalMonthString = ""
    if (finalMonth<10)
        finalMonthString = "0$finalMonth"
    else
        finalMonthString = "${finalMonth}"

    var finalDayString  = ""
    if (day.length == 3)
        finalDayString = "0${day[0]}"
    else
        finalDayString = "${day[0]}${day[1]}"

    return "$year-$finalMonthString-$finalDayString"


}