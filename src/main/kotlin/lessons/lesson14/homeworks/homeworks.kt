package lessons.lesson14.homeworks

import lessons.lesson14.homeworks.Concert
import lessons.lesson14.homeworks.Emotion

fun main(){
    //1
    val a = Party("Москва", 15)
    a.details()
    //2
    val b = Emotion("Радость", 50)
    b.express()
    //3
    Moon.showPhase()          // Full Moon
    Moon.phase = "New Moon"   // меняем фазу у единственной Луны
    Moon.isVisible = false
    Moon.showPhase()          // Луну не видно
    //4
    val first = Product("Молоко", 120.50, 1000)
    val second = Product("Сок", 100.00, 500)
    println(first)
    println(second)
    //5
    val concert = Concert("Кино", "Лужники", 2500.0, 3)
    concert.buyTicket()
    concert.buyTicket()
    concert.concertInfo()
    //6
    println("Создание и добавление полок")
    val rack = Rack(maxShelves = 3)

    val shelf1 = Shelf(capacity = 10)
    val shelf2 = Shelf(capacity = 15)
    val shelf1Duplicate = Shelf(capacity = 10)

    println("Добавляем первую полку: ${rack.addShelf(shelf1)}") // true
    println("Добавляем вторую полку: ${rack.addShelf(shelf2)}") // true
    println("Добавляем дубликат первой полки: ${rack.addShelf(shelf1Duplicate)}") // false
    println("Добавляем третью полку: ${rack.addShelf(Shelf(20))}") // true
    println("Добавляем четвертую полку (превышен лимит): ${rack.addShelf(Shelf(5))}") // false

    println("Добавление предметов")
    // Вместимость 10 (6 + 5 = 11 - не влезет, груша уйдет на следующую)
    println("Добавляем 'яблоко' (6): ${rack.addItem("яблоко")}") // true
    println("Добавляем 'груша' (5): ${rack.addItem("груша")}") // true (уйдет на 2 полку)
    println("Добавляем 'банан' (5): ${rack.addItem("банан")}") // true (уйдет на 2 полку)

    // Вывод текущего состояния
    rack.printContents()

    println("Проверки и удаление предметов")
    println("Есть ли 'яблоко': ${rack.containsItem("яблоко")}") // true
    println("Удаляем 'яблоко': ${rack.removeItem("яблоко")}") // true
    println("Удаляем 'яблоко' еще раз: ${rack.removeItem("яблоко")}") // false
    println("Есть ли 'яблоко': ${rack.containsItem("яблоко")}") // false

    rack.printContents()

    println("Сложное удаление полки")
    // Добавим еще предметов для теста
    rack.addItem("апельсин") // 8 букв
    rack.addItem("киви")     // 4 буквы
    println("Добавили апельсин и киви.")
    rack.printContents()

    println("Удаляем полку с индексом 0 (advancedRemoveShelf)...")
    val unplaced = rack.advancedRemoveShelf(0)

    println("Не удалось разместить: $unplaced") // [] - если всё влезло, или список
    println("Состояние после удаления полки:")
    rack.printContents()

    println("Обычное удаление полки")
    val removedItems = rack.removeShelf(0)
    println("Удаленная полка содержала: $removedItems")
    rack.printContents()

    println("Попытка удалить несуществующую полку: ${rack.removeShelf(99)}") // []




}



