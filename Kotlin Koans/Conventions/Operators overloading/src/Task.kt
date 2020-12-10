import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(timeInterval: AmountTimeInterval): MyDate = this.addTimeIntervals(timeInterval.interval, timeInterval.count)

data class AmountTimeInterval(val interval: TimeInterval, val count: Int)
operator fun TimeInterval.times(number: Int) = AmountTimeInterval(this, number)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
