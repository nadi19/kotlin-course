package lessons.lesson10.homeworks


//1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
val emptyMap = mapOf<Int, Int>()

//2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
val secondMap = mapOf(1.772f to 3.22, 2.33f to 4.55)

//3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
val thirdMap = mutableMapOf(1 to "qwe", 2 to "asd")

//4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
val fourthMap = mutableMapOf(1 to "asd", 2 to "zxc")

//6. Удалите определенный элемент из изменяемого словаря по его ключу.
val fithMap = mutableMapOf(1 to 2, 3 to 4, 5 to 6)

//7. Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение.
// Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
val seventhMap: Map<Double, Int> = mapOf(1.50 to 2, 2.25 to 3, 3.00 to 0)

//8. Измените значение для существующего ключа в изменяемом словаре.
val eightMap = mutableMapOf(2 to 4, 5 to 6, 7 to 8)

//9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
val nineoneMap = mapOf(1 to 2, 3 to 4)
val ninetwoMap = mapOf(5 to 6, 7 to 8)
val nainthreeMap = mutableMapOf<Int, Int>()

//10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел.
// Добавьте несколько элементов в этот словарь.
val tenList = listOf(1, 2, 3)
val tentwoList = listOf(4, 5, 6)
val tenMap = mutableMapOf("1" to tenList)

//11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк.
// Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку.
// Распечатай полученное множество.

val elevenSet = mutableSetOf("a", "b", "c")
val eleventwoSet = mutableSetOf("d", "e", "g")
val eleventhreeSet = mutableSetOf("z", "x", "y")
val elevenMap = mutableMapOf(1 to elevenSet, 2 to eleventwoSet)

//12. Создай словарь, где ключами будут пары чисел.
// Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
val twelvMap = mutableMapOf(
    (1 to 2) to 12,
    (3 to 4) to 14,
    (3 to 5) to 14,
    (3 to 7) to 15,
    (5 to 6) to 16
)

//2.1 Словарь библиотека: Ключи - автор книги, значения - список книг
val bookList1 = mutableListOf("Книга1","Книга2","Книга3")
val bookList2 = mutableListOf("Книга1","Книга2","Книга3")
val libraryMap = mutableMapOf("Автор1" to bookList1, "Автор2" to bookList2)

//2.2 Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
val plantList1 = mutableListOf("Роза","Ромашка","Пион")
val plantList2 = mutableListOf("Ель","Дуб","Береза")
val plantMap = mutableMapOf("Цветы" to plantList1, "Деревья" to plantList2)

//2.3 Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
val sportList1 = mutableListOf("Иванов","Петров","Сидоров")
val sportList2 = mutableListOf("Ложкин","Вилкин","Тарелкин")
val sportMap = mutableMapOf("Команда1" to sportList1, "Команда2" to sportList2)

//2.4 Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
val medicineList1 = mutableListOf("лекарство1","лекарство2","лекарство3")
val medicineList2 = mutableListOf("лекарство4","лекарство5","лекарство6")
val medicineMap = mutableMapOf("2026-10-08" to medicineList1, "2026-10-09" to medicineList2)

//2.5 Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
val place1List = mutableListOf("место1","место2")
val place2List = mutableListOf("место1","место2")
val journeysityMap = mutableMapOf("Москва" to place1List)
val journeysity2Map = mutableMapOf("Лондон" to place2List)
val journeyMap = mutableMapOf("Россия" to journeysityMap, "Великобритания" to journeysity2Map)

fun main() {
//4.
    fourthMap[3] = "bnm"
    println(fourthMap)

//5. Используя словарь из предыдущего задания, извлеките значение, используя ключ.
// Попробуй получить значение с ключом, которого в словаре нет.
    val wer = fourthMap[2]
    val sdf = fourthMap[5]
    println(wer)
    println(sdf)

//6.
    fithMap.remove(1)
    println(fithMap)

//7.
    for ((key, value) in seventhMap) {
        if (value != 0) {
            println(key / value)
        } else {
            println("бесконечность")
        }
    }
//8.
    eightMap[2] = 44
    println(eightMap)

//9.
    for ((key, value) in nineoneMap) {
        nainthreeMap[key] = value
    }
    for ((key, value) in ninetwoMap) {
        if (key in nainthreeMap) {
            continue
        }
        nainthreeMap[key] = value
    }
    println(nainthreeMap)

//10.
    tenMap["2"] = tentwoList
    println(tenMap)

//11.
    elevenMap[3] = eleventhreeSet
    println(elevenMap[1])
    val setFromMap = elevenMap[1]
    setFromMap?.add("zzz")
    println(elevenMap[1])

//12.
    for ((key, value) in twelvMap) {
        if (key.first == 5 || key.second == 5) {
            println(value)
        }
    }

//2.5
    journeyMap["Россия"]?.get("Москва")?.add("Новое место")
    println(journeyMap)
}