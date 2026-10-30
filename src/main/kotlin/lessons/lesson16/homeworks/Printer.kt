package lessons.lesson16.homeworks

//Принтер
//Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом фоне (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном фоне. Слова должны быть разноцветны.
// Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку при выводе текста. Проверить работу на длинном тексте

abstract class Printer {
    abstract fun printM(a: String)
}

class LaserPrinter : Printer() {
    override fun printM(a: String) {
        val words = a.split(" ")
        for (word in words) {
            if (word.isEmpty()) continue
            // Черный текст на белом фоне
            printColoredN(word, ColorsN.BLACK, BackgroundN.WHITE)
        }
    }
}

class InkjetPrinter : Printer() {
    // Палитра: пары (цвет текста, цвет фона)
    private val colorsList = listOf(
        ColorsN.RED to BackgroundN.WHITE,
        ColorsN.GREEN to BackgroundN.BLACK,
        ColorsN.YELLOW to BackgroundN.BLUE,
        ColorsN.CYAN to BackgroundN.PURPLE,
        ColorsN.WHITE to BackgroundN.RED
    )

    override fun printM(a: String) {
        val words = a.split(" ")
        var i = 0
        for (word in words) {
            if (word.isEmpty()) continue

            // Берем цвет по кругу с помощью остатка от деления (%)
            val (textColor, bgColor) = colorsList[i % colorsList.size]

            printColoredN(word, textColor, bgColor)
            i++
        }
    }
}

fun main() {
    val longText = "Полиморфизм позволяет объектам разных классов " +
            "реагировать на один и тот же вызов метода по-своему " +
            "сохраняя единый интерфейс взаимодействия"

    println("=== Лазерный принтер ===")
    val laser: Printer = LaserPrinter()
    laser.printM(longText)

    println("\n=== Струйный принтер ===")
    val inkjet: Printer = InkjetPrinter()
    inkjet.printM(longText)
}