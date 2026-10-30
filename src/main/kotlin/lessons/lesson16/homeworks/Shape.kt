package lessons.lesson16.homeworks

import kotlin.math.PI
import kotlin.math.sin

//Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
//Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус,
// для квадрата это сторона, для треугольника это две стороны и угол между ними)
//Создай набор геометрических фигур и выведи в цикле их площадь

abstract class Shape {
    open fun area(): Double {
        val s = 0.0
        return s
    }
}
class Circle(
    val radius: Double
): Shape() {
    override fun area(): Double {
        val s = PI * radius * radius
        return s
    }
}
class Square(
    val a: Double
): Shape(){
    override fun area(): Double {
        val s = a * a
        return s
    }
}
class  Triangle(
    val a: Double,
    val b: Double,
    val c: Double
): Shape() {
    override fun area(): Double {
        val angleRadians  = Math.toRadians(c)   // sin ждёт радианы
        val s = 0.5 * a * b * sin(angleRadians)
        return s
    }

}

fun  main() {
    val shape: List<Shape> = listOf(Circle(10.00), Square(5.00), Triangle(20.00,10.00,40.00))
    for(a in shape) {
        val b = a.area()
        println(b)
    }

}

