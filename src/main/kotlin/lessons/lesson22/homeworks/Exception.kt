package lessons.lesson22.homeworks

// NullPointerException
fun nullPointer() {
    val s: String? = null
    if (s == null) {
        throw NullPointerException("s равно null")
    }
    println(s.length)
}

// IndexOutOfBoundsException
fun indexOutOfBounds() {
    val list = listOf(1, 2, 3)
    println(list[10])
}

// ClassCastException
fun classCast() {
    val obj: Any = "строка"
    val num = obj as Int
}

// IllegalArgumentException
fun illegalArgument() {
    require(5 > 10) { "5 не может быть больше 10" }
}

// NumberFormatException
fun numberFormat() {
    val num = "не число".toInt()
}

// IllegalStateException
fun illegalState() {
    check(false) { "Некорректное состояние" }
}

// OutOfMemoryError
fun outOfMemory() {
    val list = mutableListOf<Long>()
    while (true) {
        list.add(Long.MAX_VALUE)
    }
}

// StackOverflowError
fun stackOverflow() {
    stackOverflow()
}

// Задание 10
fun checkArgument(arg: Any?) {
    try {
        // 1. NullPointerException
        if (arg == null) {
            throw NullPointerException("Аргумент равен null")
        }

        // 2. IndexOutOfBoundsException
        val list = listOf(1, 2, 3)
        println(list[arg as Int])

        // 3. ClassCastException
        val text = arg as String
        println(text.length)

        // 4. IllegalArgumentException
        require(arg != "плохо") { "Аргумент плохой" }

        // 5. NumberFormatException
        val parsed = arg.toString().toInt()
        println(parsed)

        // 6. IllegalStateException
        check(arg != "стоп") { "Состояние неверное" }

        println("Переданный аргумент фантастически хорош!")
    } catch (e: Throwable) {
        when (e) {
            is NullPointerException -> println("Пойман NullPointerException")
            is IndexOutOfBoundsException -> println("Пойман IndexOutOfBoundsException")
            is ClassCastException -> println("Пойман ClassCastException")
            is NumberFormatException -> println("Пойман NumberFormatException")
            is IllegalArgumentException -> println("Пойман IllegalArgumentException")
            is IllegalStateException -> println("Пойман IllegalStateException")
            else -> println("Пойман ${e::class.simpleName}")
        }
        throw e
    }
}

fun main() {
    // Задание 9
    try { nullPointer() } catch (e: NullPointerException) {
        println("Пойман NullPointerException: ${e.message}")
    }
    try { indexOutOfBounds() } catch (e: IndexOutOfBoundsException) {
        println("Пойман IndexOutOfBoundsException: ${e.message}")
    }
    try { classCast() } catch (e: ClassCastException) {
        println("Пойман ClassCastException: ${e.message}")
    }
    try { illegalArgument() } catch (e: IllegalArgumentException) {
        println("Пойман IllegalArgumentException: ${e.message}")
    }
    try { numberFormat() } catch (e: NumberFormatException) {
        println("Пойман NumberFormatException: ${e.message}")
    }
    try { illegalState() } catch (e: IllegalStateException) {
        println("Пойман IllegalStateException: ${e.message}")
    }
    try { outOfMemory() } catch (e: OutOfMemoryError) {
        println("Пойман OutOfMemoryError: ${e.message}")
    }
    try { stackOverflow() } catch (e: StackOverflowError) {
        println("Пойман StackOverflowError: ${e.message}")
    }

    // Задание 10
    try {
        checkArgument(null)
    } catch (e: Throwable) {
        println("Программа остановлена после checkArgument: ${e::class.simpleName}")
    }

    // Задание 11
    try {
        throw MyAssertionException("Моё собственное исключение на основе AssertionError")
    } catch (e: MyAssertionException) {
        println("Поймано MyAssertionException: ${e.message}")
    }

    // Задание 12
    try {
        try {
            val list = listOf(1, 2, 3)
            println(list[10])
        } catch (e: IndexOutOfBoundsException) {
            println("Поймано IndexOutOfBoundsException: ${e.message}")
            throw MyIndexException(e)
        }
    } catch (e: MyIndexException) {
        println("Поймано MyIndexException, причина: ${e.cause?.message}")
    }
}
