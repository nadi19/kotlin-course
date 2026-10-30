package lessons.lesson16.homeworks

//Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
//Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
//Выполнить перегрузку addToCart который:
//Принимает два аргумента (itemId и количество amount)
//Принимает словарь из id и количества и добавляет всё в корзину
//Принимает список из id (добавляет по одной единице).
//Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
//Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
//Переопредели у корзины метод toString для красивого форматирования содержимого таблицы,
// включая итоговое количество артикулов и общее количество всего товара в корзине.

class Basket {
    private val items: MutableMap<String, Int> = mutableMapOf()

    fun addToCart(itemId: String) {
        addToCart(itemId, 1)
    }
    fun addToCart(itemId: String, amount: Int) {
        // Если товар есть, прибавляем к текущему. Если нет — берем 0 и прибавляем.
        val currentCount = items.getOrDefault(itemId, 0)
        items[itemId] = currentCount + amount
    }
    fun addToCart(newItems: Map<String, Int>) {
        // Проходим по каждому элементу переданного словаря и используем метод №2
        for ((itemId, amount) in newItems) {
            addToCart(itemId, amount)
        }
    }
    fun addToCart(itemIds: List<String>) {
        // Проходим по списку и используем базовый метод №1
        for (itemId in itemIds) {
            addToCart(itemId)
        }
    }
    override fun toString(): String {
        if (items.isEmpty()) return "Корзина пуста"

        val sb = StringBuilder()
        sb.append("-----------------------------\n")
        sb.append(String.format("| %-12s | %-8s |\n", "Артикул", "Кол-во"))
        sb.append("-----------------------------\n")

        var totalItems = 0

        // Проходим по словарю и выводим строки таблицы
        for ((itemId, amount) in items) {
            sb.append(String.format("| %-12s | %-8d |\n", itemId, amount))
            totalItems += amount
        }

        sb.append("-----------------------------\n")
        sb.append("Уникальных артикулов: ${items.size}\n")
        sb.append("Всего товаров: $totalItems шт.\n")

        return sb.toString()
    }
}

fun main() {
    val myBasket = Basket()

    println("--- Тестируем разные способы добавления ---")

    // 1. Базовый метод (добавляет 1 шт)
    myBasket.addToCart("apple")

    // 2. С конкретным количеством (amount)
    myBasket.addToCart("banana", 3)

    // 3. Со словарем
    myBasket.addToCart(mapOf("orange" to 2, "apple" to 5)) // apple уже был, его станет 1+5=6

    // 4. Со списком (каждый по 1 шт)
    myBasket.addToCart(listOf("milk", "bread", "apple")) // apple станет 6+1=7

    // Печатаем результат
    println("\n--- Содержимое корзины ---")
    println(myBasket) // Вызов переопределенного toString()
}