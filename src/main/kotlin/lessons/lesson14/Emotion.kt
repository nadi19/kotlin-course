package lessons.lesson14


//Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию.
// У него должно быть свойство type (String) и intensity (Int).
// Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.

class Emotion(val type: String, val intensity: Int) {
    fun express() {
        val level = when {
            intensity < 5 -> "едва заметная"
            intensity < 30 -> "заметная"
            intensity < 80 -> "очень сильная"
            else -> "непонятно"
        }
        println("$type — $level (интенсивность: $intensity)")
    }
}