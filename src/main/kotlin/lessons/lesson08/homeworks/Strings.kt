package lessons.lesson08.homeworks
import lessons.lesson05.result
import java.io.PrintStream
import kotlin.text.replace

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))
    converter("Это невозможно выполнить за один день")
    converter("Я не уверен в успехе этого проекта")
    converter("Произошла катастрофа на сервере")
    converter("Этот код работает без проблем")
    converter("Удача")
    dateExtraction("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    dateExtractiontwo("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    masking("4539 1488 0343 6467")
    email("username@example.com")
    path("C:/Пользователи/Документы/report.txt")
    path("D:/good.themes/dracula.theme")
    abbreviations("Котлин лучший язык программирования")

}

//1. Преобразование строк
//Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования, делая текст более ироничным или забавным. Функция должна уметь распознавать ключевые слова или условия и соответственно изменять фразу.
//
//Правила проверки и преобразования:
//
//Если фраза содержит слово "невозможно":
//Преобразование: Замените "невозможно" на "совершенно точно возможно, просто требует времени".
//Если фраза начинается с "Я не уверен":
//Преобразование: Добавьте в конец фразы ", но моя интуиция говорит об обратном".
//Если фраза содержит слово "катастрофа":
//Преобразование: Замените "катастрофа" на "интересное событие".
//Если фраза заканчивается на "без проблем":
//Преобразование: Замените "без проблем" на "с парой интересных вызовов на пути".
//Если фраза содержит только одно слово:
//Преобразование: Добавьте перед словом "Иногда," и после слова ", но не всегда".

fun converter(phrase: String) {
    val result = when {
        phrase.contains("невозможно", true) -> phrase.replace("невозможно", "совершенно точно возможно, просто требует времени", true)
        phrase. startsWith("Я не уверен", true) -> "$phrase, но моя интуиция говорит об обратном"
        phrase.contains("катастрофа", true) -> phrase.replace("катастрофа", "интересное событие", true)
        phrase.endsWith("без проблем", ignoreCase = true) -> phrase.replace("без проблем", "с парой интересных вызовов на пути", ignoreCase = true)
        !phrase.trim().contains(" ") -> "иногда $phrase, но не всегда"
        else -> phrase
    }
    println(result)
}

//2. Извлечение даты из строки лога
//У вас есть строка лога, например "Пользователь вошел в систему -> 2021-12-01 09:48:23"
// (данные могут быть любыми, но формат всегда такой).
// Извлеките отдельно дату и время из этой строки и сразу распечатай их по очереди. Используй indexOf или split для получения правой части сообщения.

fun dateExtraction (log: String) {
    val words = log.split(" ")
    val date = words[5]
    val time = words[6]
    println(date)
    println(time)

}

fun dateExtractiontwo (log: String) {
    val ind = log.indexOf("->")
    val datatime = log.substring(ind + 2).trim()
    val part = datatime.split(" ")
    println(part[0])
    println(part[1])
}

//3. Маскирование личных данных
//Дана строка с номером кредитной карты, например "4539 1488 0343 6467". Замаскируйте все цифры, кроме последних четырех, символами "*".

fun masking(card: String) {
    var result = card
    result = result.replace(result.substring(0, 4), "****")
    result = result.replace(result.substring(5, 9), "****")
    result = result.replace(result.substring(10, 14), "****")
    println(result)
}

//4. Форматирование адреса электронной почты.
//У вас есть электронный адрес, например "username@example.com". Преобразуйте его в строку "username [at] example [dot] com", используя функцию replace()

fun email(mail: String) {
    val at = mail.indexOf('@')
    val dot = mail.indexOf('.', at + 1)
    val result = "${mail.substring(0, at)}[at]${mail.substring(at + 1, dot)}[dot]${mail.substring(dot + 1)}"
    println(result)
}

//5. Извлечение имени файла из пути.
//Дан путь к файлу, например "C:/Пользователи/Документы/report.txt" или "D:/good.themes/dracula.theme" (может быть любым).
// Извлеките название файла с расширением.

fun path(file: String) {
    val dot = file.lastIndexOf("/")
    val result = "${file.substring(dot +1)}"
    println(result)
}

//6. Создание аббревиатуры из фразы.
//У вас есть фраза, например "Котлин лучший язык программирования" (может быть любой с разделителями слов - пробел).
// Создайте аббревиатуру из начальных букв слов (например, "ООП").
//Используйте split. Используйте for для перебора слов. Используйте var переменную для накопления первых букв.

fun abbreviations(abb: String) {
    val words = abb.split(" ")
    var result = ""
    for (word in words) {
        result += word.first()
    }
    println(result.uppercase())
}


