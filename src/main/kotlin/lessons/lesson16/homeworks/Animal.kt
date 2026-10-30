package lessons.lesson16.homeworks

object ColorsN {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}
object BackgroundN {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}
fun printColoredN(text: String, color: String, backgroundColor: String = "") {
    println("$color$backgroundColor$text${ColorsN.RESET}")
}

//Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet".
// Обогати вывод звуков цветом.
//Создайте список животных List<Animal> и вызовите в цикле метод makeSound()

abstract class Animal {
    open fun makeSound() {
        println("This animal makes no sound.")
    }
}
class Dog: Animal() {
    override fun makeSound() {
        printColoredN("Bark", "\u001B[45m", "\u001B[42m")
    }
}
class Cat: Animal() {
    override fun makeSound() {
        printColoredN("Meow", "\u001B[33m", "\u001B[36m")
    }
}
class Bird: Animal() {
    override fun makeSound() {
        printColoredN("Tweet", "\u001B[30m", "\u001B[41m")
    }
}

fun main() {
    val animals: List<Animal> = listOf(Dog(), Cat(), Bird())
    for(animal in animals) {
        animal.makeSound()
    }
}
