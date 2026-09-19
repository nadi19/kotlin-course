package lessons.lesson06.homeworks

import kotlin.math.roundToInt
import kotlin.require

/*
Задание 1: "Определение сезона"
Напишите функцию, которая на основе номера месяца распечатывает сезон года.
Номера месяцев начинаются с единицы.
 */

fun seasonByMonth(month: Int) {
    require(month in 1..12) { "Месяц должен быть 1..12, получено: $month" }
    when (month) {
        12, 1, 2 -> println("Winter")
        3, 4, 5 -> println("Spring")
        6, 7, 8 -> println("Summer")
        else -> println("Autumn")
    }
}

/*
Задание 2: "Расчет возраста питомца"
Создайте функцию, которая преобразует возраст собаки в "человеческие" годы.
До 2 лет каждый год собаки равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам.
Результат распечатай в консоль.
 */

fun petAge(age: Int) {
    require(age >= 0) { "Возраст не может быть отрицательным, получено: $age" }
    if (age <= 2) {
        println(age * 10.5)
    } else {
        println(2 * 10.5 + (age - 2) * 4)
    }

}

/*
Задание 3: "Определение способа перемещения"
Напишите функцию, которая печатает в консоль, какой способ перемещения лучше использовать,
исходя из длины маршрута. Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт".
 */

fun methodMovement(length: Double) {
    require(length >= 0) { "Длина не может быть отрицательной, получено: $length" }
    if (length < 1) {
        println("on foot")
    } else if (length < 5) {
        println("bike")
    } else {
        println("motor vehicles")
    }

}

/*
Задание 4: "Расчет бонусных баллов"
Клиенты интернет-магазина получают бонусные баллы за покупки.
Напишите функцию, которая принимает сумму покупки и печатает в консоль количество бонусных баллов:
2 балла за каждые 100 рублей при сумме покупки до 1000 рублей и 3 балла за каждые 100 рублей при сумме свыше этого.
 */

fun bonus(purchaseAmount: Double) {
    require(purchaseAmount >= 0) { "Cумма не может быть отрицательной, получено: $purchaseAmount" }
    if (purchaseAmount < 1000) {
        println((purchaseAmount / 100 * 2).roundToInt())
    } else {
        println((purchaseAmount / 100 * 3).roundToInt())
    }
}

/*
Задание 5: "Определение типа документа"
В системе хранения документов каждый файл имеет расширение.
Напишите функцию, которая на основе расширения файла печатает в консоль его тип: "Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".
 */

fun storageSystem(fileExtension: String) {
    when (fileExtension) {
        ".txt" -> println("Text document")
        ".png", ".jpg", ".jpeg" -> println("Image")
        ".xls", ".xlsx" -> println("Table")
        else -> println("Unknown type")
    }

}

/*
Задание 6: "Конвертация температуры"
Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты и наоборот
в зависимости от указанной единицы измерения (C/F).
Единицу измерения нужно передать вторым аргументом функции.
Несколько аргументов передаются через запятую.
Распечатай в консоль результат конвертации с добавлением единицы измерения.
Чтобы добавить единицу измерения после результата используй функцию печати без переноса строки print("C") или print("F").
 */

fun convertTemperature(degree: Double, unitMeasurement: Char) {
    if (unitMeasurement == 'C') {
        print((degree * 9 / 5) + 32)
        println("F")
    } else {
        print((degree - 32) * 5 / 9)
        println("C")
    }
}

/*
Задание 7: "Подбор одежды по погоде"
Напишите функцию, которая на основе температуры воздуха рекомендует тип одежды:
"куртка и шапка" при температуре ниже +10,
"ветровка" от +10 до +18 градусов включительно и
"футболка и шорты" при температуре выше +18 градусов.
При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.
 */

fun clotheSelecting(temperature: Int) {
    if (temperature < -30 || temperature > 35) {
        println("don't leave house")
    } else if (temperature < 10) {
        println("jacket and hat")
    } else if (10 <= temperature && temperature <= 18) {
        println("windbreaker")
    } else {
        println("T-shirt and shorts")
    }
}

/*
Задание 8: "Выбор фильма по возрасту"
Кинотеатр предлагает фильмы разных возрастных категорий.
Напишите функцию, которая принимает возраст зрителя и
возвращает доступные для него категории фильмов:
"детские" (от 0 до 9),
"подростковые" (от 10 до 18),
"18+" для остальных.
 */

fun movieChoosing(age: Int) {
    when (age) {
        in 0..9 -> println("children's")
        in 10..18 -> println("teen")
        else -> println("18+")
    }
}

fun main() {
    // Задание 1
    seasonByMonth(12) // Winter
    seasonByMonth(4)  // Spring
    seasonByMonth(7)  // Summer
    seasonByMonth(10) // Autumn
    // Задание 2
    petAge(12)
    petAge(1)
    // Задание 3
    methodMovement(0.5)  // on foot
    methodMovement(3.0)   // bike
    methodMovement(17.0)  // motor vehicles
    // Задание 4
    bonus(2000.0)
    bonus(100.50)
    // Задание 5
    storageSystem(fileExtension = ".txt")
    storageSystem(fileExtension = ".png")
    storageSystem(fileExtension = ".jpg")
    storageSystem(fileExtension = ".jpeg")
    storageSystem(fileExtension = ".xls")
    storageSystem(fileExtension = ".xlsx")
    storageSystem(fileExtension = ".dssx")
    // Задание 6
    convertTemperature(123.0, 'C')
    convertTemperature(4000.0, 'F')
    // Задание 7
    clotheSelecting(12)
    clotheSelecting(5)
    clotheSelecting(19)
    clotheSelecting(-31)
    clotheSelecting(36)
    //Задание 8
    movieChoosing(2)
    movieChoosing(14)
    movieChoosing(21)

}

