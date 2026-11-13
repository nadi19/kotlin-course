package lessons.lesson19.homeworks

//2. Напиши класс ListHolder, который будет хранить список элементов типа T и
// иметь метод для добавления нового элемента и получения всех элементов в виде неизменяемого списка.
class ListHolder<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> = items.toList()
}