package lessons.lesson19.homeworks

//Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
// если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.isEmpty()) return null
    if (list.size % 2 == 0) return null
    val middleIndex = list.size / 2
    return list[middleIndex]
}