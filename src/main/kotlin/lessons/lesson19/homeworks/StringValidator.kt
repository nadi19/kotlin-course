package lessons.lesson19.homeworks

//7. Создай класс StringValidator и имплементируй интерфейс Validator с типом String?.
// Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.

class StringValidator : Validator<String?> {
    override fun validate(item: String?): Boolean {
        return item != null && item.isNotBlank()
    }
}