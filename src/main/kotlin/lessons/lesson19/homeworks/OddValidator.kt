package lessons.lesson19.homeworks

//8. Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int. Реализуй проверку, что число чётное.

class OddValidator : Validator<Int> {
    override fun validate(item: Int): Boolean {
        return item % 2 == 0
    }
}