package lessons.lesson15.homeworks

import kotlin.math.PI
import kotlin.math.sqrt

abstract class Geometric(
    val name: String
) {
    // Краткое описание фигуры
    open fun describe(): String =
        "наименование: $name, площадь: ${area()}"

    // Площадь — по умолчанию 0
    open fun area(): Double = 0.0

    // Сравнение по площади
    fun isLargerThan(other: Geometric): Boolean =
        this.area() > other.area()
}

open class Polygon(
    name: String,
    val sidesCount: Int, // число сторон (обычно ≥ 3)
    val sides: List<Double> = emptyList() // длины сторон
): Geometric(name) {

    // Сумма длин всех сторон
    fun sumOfSides(): Double = sides.sum()
}

open class Circle(
    name: String,
    val radius: Double // радиус
): Geometric(name) {

    // Длина окружности
    fun circumference(): Double = 2 * PI * radius

    // Площадь круга
    override fun area(): Double = PI * radius * radius
}

open class Triangle(
    name: String,
    sides: List<Double>
): Polygon(name, 3, sides) {

    // Является ли треугольник равносторонним (все стороны равны)
    fun isEquilateral(): Boolean = sides.distinct().size == 1
}

open class Quadrilateral(
    name: String,
    sides: List<Double>
): Polygon(name, 4, sides) {

    // Является ли четырёхугольник квадратом (все стороны равны)
    fun isSquare(): Boolean = sides.distinct().size == 1
}

fun main() {
    val circle = Circle("Круг", 5.0)
    val triangle = Triangle("Треугольник", listOf(3.0, 4.0, 5.0))
    val quadrilateral = Quadrilateral("Четырёхугольник", listOf(3.0, 3.0, 4.0, 4.0))

    println(circle.describe())
    println(triangle.describe())
    println(quadrilateral.describe())

    println("---")
    println("Длина окружности? ${circle.circumference()}")
    println("Сумма сторон четырёхугольника? ${quadrilateral.sumOfSides()}")
    println("Круг больше треугольника? ${circle.isLargerThan(triangle)}")
}