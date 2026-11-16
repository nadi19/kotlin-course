package lessons.lesson20.homeworks

import kotlin.math.absoluteValue

//1. Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел
// - первое и последнее. Если массив был пуст то вернуть пару из null значений.

fun Array<Int>.firstAndLast(): Pair<Int?, Int?> {
    if (this.isEmpty()) {
        return Pair(null, null)
    }
    return Pair(this.first(), this.last())
}

//2. Создайте функцию-расширение для изменяемого списка элементов:
//с дженериком T ограниченным интерфейсом Comparable<T>
//которая принимает булево значение
//возвращает этот же список только в виде неизменяемого
//сам изменяемый список при этом должен стать отсортированным по возрастанию,
// если в функцию передано true и по убыванию, если false (используем функции sort() и sortDescending()

fun <T : Comparable<T>> MutableList<T>.sortedCopy(ascending: Boolean): List<T> {
    if (ascending) {
        this.sort()
    } else {
        this.sortDescending()
    }
    return this.toList() // неизменяемая копия
}

//3. Создайте функцию-расширение для nullable словаря с дженериком:
//Ключ является дженериком
//Значение является списком из дженериков
//Принимает целое число
//Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
//Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого индекса нет - значением будет null

fun <K, V> Map<K, List<V>>?.toStringKeyMap(index: Int): Map<String, V?>? {
    if (this == null) return null

    val result = mutableMapOf<String, V?>()
    for ((key, valueList) in this) {
        val stringKey = key.toString()
        val value = valueList.getOrNull(index) // null, если индекса нет
        result[stringKey] = value
    }
    return result
}

//4. Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от эталонного
// не более допустимого значения. Метод принимает два параметра: other — число для
// сравнения и deviation — максимально допустимое отклонение. Метод должен возвращать true,
// если разница между текущим числом и числом для сравнения не превышает заданное отклонение.
// Протестируйте функцию на разных типах чисел. Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.

fun Number.within(other: Number, deviation: Number): Boolean {
    val diff = (this.toDouble() - other.toDouble()).absoluteValue
    return diff <= deviation.toDouble()
}

//5. Реализуйте для класса String два метода расширения: encrypt и decrypt.
// Метод encrypt должен сдвигать каждый символ исходной строки на заданное число позиций вперед по таблице Unicode,
// а метод decrypt — на то же число позиций назад. Оба метода принимают один параметр base типа Int,
// который определяет величину сдвига. Протестируйте вашу реализацию, убедившись,
// что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.
//Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.

fun String.encrypt(base: Int): String {
    return this.map { it + base }.joinToString("")
}

fun String.decrypt(base: Int): String {
    return this.map { it - base }.joinToString("")
}

//6. Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы
// (но мы то знаем что слово только одно, но не будем его называть). Напиши метод расширения строки,
// который будет принимать список имён пользователей и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик:
// имя автора и букву под ним. Вот ссылка на референс:
//https://x.com/SadNSober_/status/1370280031616897026

fun String.printWithAuthors(authors: List<String>) {
    this.uppercase().forEachIndexed { index, char ->
        val author = authors.getOrNull(index) ?: "Unknown"
        println(author)
        println(char)
    }
}

fun main() {
    // 1
    println(arrayOf(1, 2, 3).firstAndLast())   // (1, 3)
    println(arrayOf<Int>().firstAndLast())     // (null, null)

    // 2
    val list = mutableListOf(3, 1, 2)
    println(list.sortedCopy(true))             // [1, 2, 3]

    // 4
    println(5.within(7, 2))                    // true

    // 5
    val s = "Hello"
    println(s.encrypt(3).decrypt(3) == s)      // true

    // 6
    "kotlin".printWithAuthors(listOf("Alice", "Bob"))
}


