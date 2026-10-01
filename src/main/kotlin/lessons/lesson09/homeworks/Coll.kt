package lessons.lesson09.homeworks

fun main() {
//1.1 Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val numbers = arrayOf(1, 2, 3, 4, 5)
    println(numbers.contentToString())

//2.1 Создайте пустой массив строк размером 10 элементов.
    val strings = Array(10) { "" }

//3.1 Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val qwa = DoubleArray(5) { i -> i * 2.0 }

//4.1 Создайте массив из 5 элементов типа Int.
// Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val asd = IntArray(5)
    for (i in asd.indices) {
        asd[i] = i * 3
    }

//5.1 Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val zxc = arrayOfNulls<String>(3)
    zxc[0] = "qwerty"
    zxc[1] = "addasdd"

//6.1 Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val vbn = intArrayOf(1, 2, 3, 4, 5, 6)
    val nmb = IntArray(6)
    for (i in vbn.indices) {
        nmb[i] = vbn[i]
    }

//7.1 Создайте два массива целых чисел одинаковой длины.
// Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val tyu = intArrayOf(1, 2, 3, 4, 5, 6)
    val hjk = intArrayOf(4, 6, 9, 8, 7, 6)
    val uyt = IntArray(6)
    for (i in uyt.indices) {
        uyt[i] = hjk[i] - tyu[i]
    }
    println(uyt.contentToString())

//8.1 Создайте массив целых чисел. Найдите индекс элемента со значением 5.
// Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val iuy = intArrayOf(1, 3, 6, 6, 5, 9)
    var i = 0
    var result = -1
    while (i < iuy.size) {
        if (iuy[i] == 5) {
            result = i
            break
        }
        i++

    }
    println(result)

//9.1 Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль.
// Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val oiu = intArrayOf(1, 3, 2, 3, 543, 3)
    for (number in oiu) {
        if (number % 2 == 0) {
            println("$number - чётное")
        } else {
            println("$number - нечётное")
        }
    }
//10.1
    val fruits = arrayOf("яблоко", "банан", "абрикос", "груша")
    val found = findBySubstring(fruits, "банан")
    println(found)

//1.2 Создайте пустой неизменяемый список целых чисел.
    val readonlyList: List<Int> = emptyList()

//2.2 Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val readOnly: List<String> = listOf("Hello", "World", "Kotlin")

//3.2 Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

//4.2 Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    val qweList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    qweList.add(6)
    qweList.add(7)
    qweList.add(8)

//5.2 Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val rtyList: MutableList<String> = mutableListOf("Hello", "World")
    rtyList.remove("World")

//6.2 Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val dfgList: List<Int> = listOf(1, 2, 5, 7, 8)
    for (i in dfgList) {
        println(i)
    }
//7.2 Создайте список строк и получите из него второй элемент, используя его индекс.
    val asdList: List<String> = listOf("1", "2", "3", "4")
    println(asdList[1])

//8.2 Имея изменяемый список чисел,
// измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    val cvbList: MutableList<Int> = mutableListOf(1, 2, 3, 4)
    cvbList[2] = 12

//9.2 Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков.
// Реши задачу с помощью циклов.
    val firstList: List<String> = listOf("п", "р", "и")
    val secondList: List<String> = listOf("в", "е", "т")
    val thirdList: MutableList<String> = mutableListOf()
    for (i in firstList) {
        thirdList.add(i)
    }
    for (i in secondList) {
        thirdList.add(i)
    }
//10.2 Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val hgfList: List<Int> = listOf(1, 5, 7, 3, 45, 232, 76)
    var min = hgfList[0]
    var max = hgfList[0]
    for (i in hgfList) {
        if (i < min) {
            min = i
        }
        if (i > max) {
            max = i
        }
    }
    println("Минимум: $min")
    println("Максимум: $max")

// 11.2 Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val bnmList: List<Int> = listOf(1, 8, 5, 67, 43, 22)
    val chList: MutableList<Int> = mutableListOf()
    for (i in bnmList) {
        if (i % 2 == 0) {
            chList.add(i)
        }
    }
    println(chList)

//1.3 Создайте пустое неизменяемое множество целых чисел.
    val dsdSet: Set<Int> = setOf()

//2.3 Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val lkjSet: Set<Int> = setOf(1, 2, 3)

//3.3 Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val iopSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

//4.3 Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    val dsaSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
    dsaSet.add("Swift")
    dsaSet.add("Go")
//5.3 Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val kjhSet: MutableSet<Int> = mutableSetOf(1, 2, 4, 6, 8)
    kjhSet.remove(2)

//6.3 Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val zxcSet: Set<Int> = setOf(1, 33, 44, 55, 66, 99)
    for (i in zxcSet) {
        println(i)
    }

//8.3 Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val vcbSet: Set<String> = setOf("aaa", "ddd", "fff")
    val xzxList: MutableList<String> = mutableListOf()
    for (i in vcbSet) {
        xzxList.add(i)
    }
    println(xzxList)
}


//10.1 Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()).
//Распечатай найденный элемент.
fun findBySubstring(array: Array<String>, search: String): String? {
    for (element in array) {
        if (element.contains(search)) {
            return element
        }
    }
    return null
}

//7.3 Создай функцию, которая принимает множество строк (set) и строку и проверяет,
// есть ли в множестве указанная строка. Нужно распечатать булево значение true если строка есть.
// Реши задачу через цикл.
fun findByset(aset: Set<String>, search: String) {
    for (el in aset) {
        if (el == search) {
            println(true)
            return
        }
    }
    println(false)
}