import java.util.*

class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateIterator(this)
    }
}

class DateIterator: Iterator<MyDate> {
    var currentDate: MyDate
    val endDate: MyDate

    constructor(range: DateRange) {
        currentDate = range.start
        endDate = range.end
    }

    override fun hasNext(): Boolean = currentDate <= endDate

    override fun next(): MyDate {
        val today = currentDate
        currentDate = currentDate.followingDate()
        return today
    }

}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}