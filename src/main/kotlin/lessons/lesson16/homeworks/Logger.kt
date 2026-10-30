package lessons.lesson16.homeworks

//Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
//Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
//Выполнить перегрузку метода log, который:
//Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
//Принимает список сообщений и все их выводит с уровнем INFO
//Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
//Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.

class Logger {
    fun log(message: String) {
        println("[INFO] $message")
    }
    fun log(level: String, message: String) {
        when (level.uppercase()) {
            "INFO" -> log(message) // Делегируем базовому методу
            "WARNING" -> {
                // Желтый цвет текста, без фона
                printColoredN("[WARNING] $message", ColorsN.YELLOW)
            }
            "ERROR" -> {
                // Белый текст на красном фоне
                printColoredN("[ERROR] $message", ColorsN.WHITE, BackgroundN.RED)
            }
            "DEBUG" -> {
                // Для дебага можно использовать, например, голубой цвет
                printColoredN("[DEBUG] $message", ColorsN.CYAN)
            }
            else -> {
                // Если передан неизвестный уровень, выводим как INFO
                println("[$level] $message")
            }
        }
    }
    fun log(messages: List<String>) {
        for (msg in messages) {
            log(msg) // Вызываем базовый метод
        }
    }
    fun log(exception: Exception) {
        // Берем сообщение из исключения и передаем в метод с уровнем ERROR
        log("ERROR", exception.message ?: "Неизвестная ошибка")
    }
}

fun main() {
    val logger = Logger()

    println("--- 1. Базовый метод (INFO) ---")
    logger.log("Приложение запущено")

    println("\n--- 2. С указанием уровня (WARNING и ERROR) ---")
    logger.log("WARNING", "Мало свободной памяти")
    logger.log("ERROR", "Не удалось подключиться к базе данных")

    println("\n--- 3. Список сообщений (все INFO) ---")
    val startupLogs = listOf(
        "Загрузка конфигурации...",
        "Инициализация модулей...",
        "Сервер готов к работе"
    )
    logger.log(startupLogs)

    println("\n--- 4. Объект Exception (ERROR) ---")
    try {
        val numbers = listOf(1, 2, 3)
        println(numbers[5]) // Вызовет IndexOutOfBoundsException
    } catch (e: Exception) {
        logger.log(e) // Передаем само исключение в логгер
    }
}