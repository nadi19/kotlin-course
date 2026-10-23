package lessons.lesson14

//Класс Rack (Стеллаж)
//Характеристики:
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.

class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()

    //Добавление Полки (addShelf):
//Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен
// или была попытка добавить полку которая уже установлена.
    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.contains(shelf) || shelves.size == maxShelves) {
            return false
        }
        shelves.add(shelf)
        return true
    }

    //Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
    fun removeShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }
        val items = shelves[index].getItems()
        shelves.removeAt(index)
        return items
    }

    //Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
    fun addItem(name: String): Boolean {
        if (shelves.isEmpty()) {
            return false
        }
        for (shelf in shelves) {
            if (shelf.canAccommodate(name)) {
                return shelf.addItem(name)
            }
        }
        return false
    }

    ////Удаление Предмета (removeItem):
    ////Находит и удаляет только один предмет с любой полки.
    ////Возвращает true, если предмет был удален, и false, если такой предмет не найден.
    fun removeItem(name: String): Boolean {
        for (shelf in shelves) {
            if (shelf.containsItem(name)) {
                return shelf.removeItem(name)
            }
        }
        return false
    }

    //Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
    fun containsItem(name: String): Boolean {
        return shelves.any { it.containsItem(name) }
    }

    //Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
    fun getShelves() = shelves.toList()

    ////Печать Содержимого (printContents):
    ////Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов.
    //// Информацию выводить в наглядном читаемом виде
    fun printContents() {
        for (i in shelves.indices) {
            val capacity = shelves[i].capacity
            val accessiblePlace = capacity - shelves[i].getItems()
                .map { it.length }
                .sum()
            val meta = "$i вместимость: $capacity доступно: $accessiblePlace"
            val items = shelves[i].getItems().joinToString()
            println(meta)
            println("Предметы: $items")
            println()
        }
    }

    //Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.
    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()

        // 1. Берем предметы удаляемой полки и СОРТИРУЕМ ИХ ПО УБЫВАНИЮ ДЛИНЫ
        val itemsToMove = shelves[index].getItems().sortedByDescending { it.length }

        // 2. Сразу удаляем полку, чтобы предметы не пытались лечь обратно в неё
        shelves.removeAt(index)

        val notPlaced = mutableListOf<String>()

        // 3. Пытаемся распределить
        for (item in itemsToMove) {
            val placed = addItem(item) // используем метод стеллажа addItem
            if (!placed) {
                notPlaced.add(item)
            }
        }

        return notPlaced.toList()
    }
}