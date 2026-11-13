package lessons.lesson19.homeworks

//5. Создай функцию transposition с двумя дженериками,
// которая принимает словарь с дженериками и возвращает словарь, в котором ключ и значения поменялись местами.

fun <K, V> transposition(map: Map<K, V>): Map<V, K> {
    val result = mutableMapOf<V, K>()
    for ((key, value) in map) {
        result[value] = key
    }
    return result
}