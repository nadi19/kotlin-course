package lessons.lesson11.homeworks


//1. Не принимает аргументов и не возвращает значения.

fun first() {
    println("Hello")
}

//2. Принимает два целых числа и возвращает их сумму.

fun secondSum(a: Int, b: Int): Int {
    return a + b
}

//3. Принимает строку и ничего не возвращает.

fun thirdString(a: String) {
    println(a)
}

//4. Принимает список целых чисел и возвращает среднее значение типа Double.

fun fourthAvg(a: List<Int>): Double {
    var i = 0
    for (number in a) {
        i += number
    }
    val c = a.size
    val n = i.toDouble() / c
    return n
}

//5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.

private fun fithLang(a: String?): Int? {
    val b = a?.length
    return b
}

//6. Не принимает аргументов и возвращает nullable вещественное число.

fun six(): Double? {
    return 2.22
}

//7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.

private fun seven(a: List<Int>?) {
    println(a)
}

//8. Принимает целое число и возвращает nullable строку.

fun eight(a: Int): String? {
    return a.toString()
}

//9. Не принимает аргументов и возвращает список nullable строк.

fun nine(): List<String?> {
    return listOf("qwerty", "", "1")
}

//10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.

fun ten(a: String?, b: Int?): Boolean? {
    if (a == null || b == null) {
        return null
    }
    return true
}


//11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.

fun multiplyByTwo(a: Int): Int {
    return a * 2
}

//12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.

fun isEven(a: Int): Boolean {
    if (a % 2 == 0) {
        return true
    }
    return false
}

//13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.

fun printNumbersUntil(n: Int) {
    if (n < 1) return
    for (number in 1..n) {
        println(number)
    }
}

//14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке.
// Если отрицательных чисел нет, функция должна вернуть null.

fun findFirstNegative(a: List<Int>): Int? {
    for (number in a) {
        if (number < 0) {
            return number
        }
    }
    return null
}


//15. Напишите функцию processList, которая принимает список строк.
// Функция должна проходить по списку и выводить каждую строку.
// Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.

fun processList(a: List<String?>) {
    for (number in a) {
        if (number == null) return
        println(number)
    }
}


fun main() {
    first()
    println(secondSum(2, 3))
    thirdString("test")
    println(fourthAvg(listOf(1, 2, 3, 4)))

    println(fithLang("привет"))
    println(fithLang(null))

    println(six())
    seven(listOf(1, 2, 3))
    println(eight(42))
    println(nine())
    println(ten("a", 1))

    println(multiplyByTwo(5))
    println(isEven(4))

    printNumbersUntil(3)
    println(findFirstNegative(listOf(3, -1, 5)))
    processList(listOf("a", null, "c"))
}