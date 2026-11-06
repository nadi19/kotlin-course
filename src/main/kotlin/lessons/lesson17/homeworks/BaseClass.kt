package lessons.lesson17.homeworks

abstract class BaseClass(
    private val privateVal: String,
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    // ВНИМАНИЕ: чтобы п.6 был выполним, сеттер обязан быть здесь,
    // т.к. privateField недоступен наследнику. По условию BaseClass
    // "доработке не подлежит" — тогда п.6 невыполним из main().
    // Оставляю метод как демонстрацию (раскомментируйте, если разрешено):
    // fun setPrivateField(value: String) { privateField = value }

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass()
    private class PrivateClass()
}

class ChildrenClass(
    val privateVal: String,          // своё публичное свойство (затеняет родительское)
    protectedVal: String,            // просто параметр, уходит в super
    publicVal: String                // просто параметр, уходит в super
) : BaseClass(privateVal, protectedVal, publicVal) {

    // п.4: разрешаем установить "Антонио Бандераса"
    override fun verifyPublicField(value: String): Boolean {
        return value.length < 3 || value == "Антонио Бандераса"
    }

    // п.5: публичный сеттер для protectedField
    fun setProtectedField(value: String) {
        protectedField = value
    }

    // п.6: без доработки BaseClass изменить privateField невозможно.
    // Если BaseClass можно править — раскомментируйте setPrivateField в BaseClass.

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    // Это НЕ override privatePrint из BaseClass — просто отдельный private-метод
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
}

fun main() {
    val children = ChildrenClass(
        privateVal = "priv",
        protectedVal = "prot",
        publicVal = "pub"
    )

    // п.1: читаем СВОЁ public-свойство privateVal наследника
    println("privateVal (наследника): ${children.privateVal}")

    // п.2: children.protectedVal — НЕ компилируется (protected)
    // println(children.protectedVal)

    // п.3-4: меняем publicField
    children.publicField = "Антонио Бандераса"

    // п.5: меняем protectedField через сеттер наследника
    children.setProtectedField("protected изменён из main")

    // п.6: children.setPrivateField(...) — недоступно без правки BaseClass

    // п.8-12: смотрим результат
    println("---- getAll() ----")
    println(children.getAll())

    // п.12: печатает "Печать из класса BaseClass"
    println("---- printText() ----")
    children.printText()
}