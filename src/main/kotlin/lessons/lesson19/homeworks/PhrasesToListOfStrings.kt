package lessons.lesson19.homeworks

//4. Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
// Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.
// Метод преобразования списков с аналогичной механикой.

class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun map(item: String): List<String> {
        return item.split(" ")
    }

    override fun mapList(items: List<String>): List<List<String>> {
        return items.map { map(it) }
    }
}