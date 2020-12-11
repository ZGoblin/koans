class LazyProperty(val initializer: () -> Int) {
    var temp: Int? = null
    val lazy: Int
        get() {
            if(temp == null) temp = initializer()
            return temp!!
        }
}
