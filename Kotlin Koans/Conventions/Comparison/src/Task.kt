data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        if (year - other.year == 0) {
            if (month - other.month == 0) {
                return dayOfMonth - other.dayOfMonth
            }
            return month - other.month
        }
        return year - other.year
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
