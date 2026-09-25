package lessons.lesson07.homeworks

//2. Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for.
// 'arg' - целочисленный аргумент функции.
fun sumArg(arg: Int) {
    var sum: Int = 0
    for (i in 1..arg) {
        sum += i
    }
    println(sum)
}

//3. Напишите функцию, которая вычисляет факториал числа 'arg' с использованием цикла while.
fun factorial(arg: Int) {
    var fact: Int = 1
    var i: Int = 1
    while (i <= arg) {
        fact *= i
        i++
    }
    println(fact)
}

//4. Напишите функцию, которая находит сумму всех четных чисел от 2 до 'arg', используя цикл while.
fun sumEven(arg: Int) {
    var sum: Int = 0
    var i: Int = 2
    while (i in 2..arg) {
        if (i % 2 == 0) {
            sum += i
        }
        i += 2
    }
    println(sum)
}

//5. Напишите функцию, которая используя вложенные циклы while,
// выведет заполненный прямоугольник размером 5x3 из символов
fun rectangle(arg: Char) {
    var row: Int = 1
    while (row <= 5) {
        var count: Int = 1
        while (count <= 3) {
            print(arg)
            count++
        }
        println()
        row++
    }
}

//6. Напишите функцию, которая используя цикл for найдёт суммы чётных и нечётных значений чисел от 1 до arg.
fun sumels(arg: Int) {
    var sumEven = 0
    var sumOdd = 0
    for (i in 1..arg) {
        if (i % 2 == 0) {
            sumEven += i
        } else {
            sumOdd += i
        }
    }
    println("sum even " + sumEven)
    println("sum odd " + sumOdd)
}


fun main() {
//1. Используя вложенный цикл реализовать таблицу умножения, как на картинке.
    var a = 1
    for (i in 1..10) {
        for (j in 1..10) {
            print(i * j)
            print(" ")
        }
        print("\n")
    }
    println()
//2.
    sumArg(12)
    sumArg(4)
//3.
    factorial(5)
//4.
    sumEven(10)
//5.
    rectangle('$')
//6.
    sumels(12)
}

