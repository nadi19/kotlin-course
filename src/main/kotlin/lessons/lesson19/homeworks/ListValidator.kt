package lessons.lesson19.homeworks

//9. Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator типизированный по типу List с nullable типом дженерика класса
//Реализуй проверку:
//Ни один элемент списка не является null
//Ни один элемент приведённый к типу Double не равен 0.0


class ListValidator<T : Number> : Validator<List<T?>> {
    override fun validate(item: List<T?>): Boolean {
        if (item.any { it == null }) return false
        if (item.any { it!!.toDouble() == 0.0 }) return false
        return true
    }
}