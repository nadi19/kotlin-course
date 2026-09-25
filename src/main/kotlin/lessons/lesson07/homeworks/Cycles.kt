package lessons.lesson07.homeworks

fun main() {
    //1. Напишите цикл for, который выводит числа от 1 до 5.
    for (i in 1..5) {
        println("task1 " + i)
    }
    //2. Напишите цикл for, который выводит четные числа от 1 до 10.
    for (i in 1..10) {
        if (i % 2 == 0) {
            println("task2 " + i)
        }
    }
    //3. Создайте цикл for, который выводит числа от 5 до 1.
    for (i in 5 downTo 1) {
        println("task3 " + i)
    }
    //4. Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (i in 10 downTo 1 step 2) {
        println("task4 " + i)
    }
    //5. Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    for (i in 1..9 step 2) {
        println("task5 " + i)
    }
    //6. Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (i in 1..20 step 3) {
        println("task6 " + i)
    }
    //7. Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size: Int = 15
    for (i in 3 until size step 2) {
        println("task7 " + i)
    }
    //8. Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var a = 1
    while (a in 1..5) {
        println("task8 " + a * a)
        a++
    }
    //9. Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var b: Int = 10
    while (b in 10 downTo 5) {
        println("task9 " + b)
        b--

    }
    //10. Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var c: Int = 5
    do {
        println("task10 " + c)
        c--
    } while (c in 5 downTo 1)
    //11. Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
    var d: Int = 5
    do {
        println("task11 " + d)
        d++
    } while (d < 10)
    //12. Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (v in 1..10) {
        if (v == 6) break
        println("task12 " + v)
    }
    //13. Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
    var e: Int = 1
    while (e >= 1) {
        println("task13 " + e)
        if (e == 10) break
        e++
    }
    //14. В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println("task14 " + i)
    }
    //15. Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    var f: Int = 1
    while (f in 1..10) {
        if (f % 3 == 0) {
            f++
            continue
        }
        println("task15 " + f)
        f++

    }
}






