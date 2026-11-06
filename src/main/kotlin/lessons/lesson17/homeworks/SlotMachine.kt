package lessons.lesson17.homeworks
//Игровой автомат
//Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var)
// и методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)

class SlotMachine(
    // поля
    val color: String,                 // цвет — не меняется
    val model: String,                 // модель — не меняется
    val supportPhone: String,          // телефон поддержки — не меняется
    var owner: String,                 // владелец — может меняться
    private val pinCode: String        // пин-код — приватный, только чтение
) {
    // Приватные поля состояния
    private var isPowerOn: Boolean = false          // включён
    private var isOsLoaded: Boolean = false         // ОС загружена
    private var hasJoystick: Boolean = true         // наличие джойстика
    private var balance: Double = 0.0               // баланс вырученных средств
    private var isSessionPaid: Boolean = false      // игровой сеанс оплачен
    private var sessionPrice: Double = 0.0          // стоимость одного сеанса
    private val installedGames: MutableList<String> = mutableListOf()  // список игр

    //включить
    fun turnOn(): Boolean {
        isPowerOn = true            // было: var isPowerOn = true
        println("Аппарат включён")
        return isPowerOn
    }
    //выключить
    fun turnOff(): Boolean {
        isPowerOn = false           // было: var isPowerOn = false
        println("Аппарат выключён")
        return isPowerOn
    }
    //загрузить ОС
    private fun loadOnOC(): Boolean {
        isOsLoaded = true           // было: var isOsLoaded = true
        println("ОС загружена")
        return isOsLoaded
    }
    //завершить работу ОС
    private fun loadOffOC(): Boolean {
        isOsLoaded = false          // было: var isOsLoaded = false
        println("Завершение работы")
        return isOsLoaded
    }
    //показать список игр
    fun showGames() {
        println(installedGames)     // было: var showGames = installedGames
    }
    //включить игру
    fun startGame(gameName: String): Boolean {
        println("Игра запущена")
        return true                 // было: var isGameLoaded = true
    }
    //оплатить игровой сеанс
    fun payForGame(): Boolean {
        isSessionPaid = true        // было: var isSessionPaid = true
        println("игра оплачена")
        return isSessionPaid
    }
    //забрать наличные с помощью пин-кода
    fun withdrawCash(enteredPin: String): Double? {
        if (enteredPin != pinCode) {        // сверяем с приватным полем
            println("Неверный пин-код")
            return null
        }
        val amount = balance
        if (openSafeAndDispense(amount)) {
            balance = 0.0
            return amount
        }
        return null
    }
    //открыть сейф и выдать наличные
    private fun openSafeAndDispense(amount: Double): Boolean {
        println("Сейф открыт, выдано $amount")
        return true                 // без return не компилировалось
    }
}