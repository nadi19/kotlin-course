package lessons.lesson19.homeworks

//6. Напиши интерфейс Validator с дженериком с функцией валидации,
// которая будет принимать элемент с типом дженерика и возвращать булево значение.

interface Validator<T> {
    fun validate(item: T): Boolean
}