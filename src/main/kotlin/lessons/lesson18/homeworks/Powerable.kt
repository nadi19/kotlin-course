package lessons.lesson18.homeworks

import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}
//Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
//
//Холодильник
abstract class Refrigerator: Powerable, Openable, TemperatureRegulatable
//Стиральная машина
abstract class WashingMachine: Powerable, Openable, WaterContainer, WaterConnection, Drainable, Programmable
//Умная лампа
abstract class SmartLamp: Powerable, LightEmitting, Programmable, Rechargeable
//Электронные часы
abstract class ElectronicClock : Powerable, Timable, Programmable, BatteryOperated
//Робот-пылесос
abstract class RobotVacuumCleaner : Powerable, Movable, Cleanable, Programmable, Rechargeable, AutomaticShutdown
//Механические часы
abstract class MechanicalClock : Mechanical, Timable
//Фонарик
abstract class Flashlight : Powerable, LightEmitting, BatteryOperated
//Кофемашина
abstract class CoffeeMachine : Powerable, WaterContainer, TemperatureRegulatable, Programmable, AutomaticShutdown
//Умная колонка
abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable, Rechargeable

//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс
// с реализацией методов (достаточно println с выполняемым действием).
abstract class IncludedEquipment: Powerable {
    protected var isPoweredOn: Boolean = false
        private set
    override fun powerOn() {
        isPoweredOn = true
        println("Устройство включено")
    }

    override fun powerOff() {
        isPoweredOn = false
        println("Устройство выключено")
    }
}
//Задача 3. Создай абстрактный класс для программируемого оборудования
// (с имплементацией соответствующего интерфейса и реализацией методов) и
// наследуй его от абстрактного класса включаемого оборудования.
abstract class ProgrammableEquipment: IncludedEquipment(), Programmable  {
    protected var currentAction: String? = null

    override fun programAction(action: String) {
        if (!isPoweredOn) {
            println("Невозможно запрограммировать: устройство выключено")
            return
        }
        currentAction = action
        println("Запрограммировано действие: $action")
    }

    override fun execute() {
        if (!isPoweredOn) {
            println("Невозможно выполнить: устройство выключено")
            return
        }
        val action = currentAction
        if (action == null) {
            println("Действие не задано")
            return
        }
        println("Выполняется: $action")
    }
}
//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру
// и открываться и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class TemperatureOpenableEquipment :
    ProgrammableEquipment(), Openable, TemperatureRegulatable {

    protected var isOpen: Boolean = false

    override fun open() {
        isOpen = true
        println("Дверца открыта")
    }

    override fun close() {
        isOpen = false
        println("Дверца закрыта")
    }

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn) {
            println("Невозможно установить температуру: устройство выключено")
            return
        }
        if (temp > maxTemperature) {
            println("Температура $temp превышает максимум $maxTemperature")
            return
        }
        println("Температура установлена: $temp")
    }
}
//Задача 5. Создай не абстрактные классы устройств с наследованием от
// абстрактного класса с возможностью устанавливать температуру и открываться.
// Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие интерфейсы и
// реализуй необходимые методы (достаточно вывод в консоль производимого действия).
// Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы)
// не имеет смысла при выключенном питании - добавь эту проверку.
class Refrigerat(
    override val capacity: Int,
    override val maxTemperature: Int = 8
) : TemperatureOpenableEquipment(), WaterContainer {

    private var waterAmount: Int = 0

    override fun fillWater(amount: Int) {
        waterAmount += amount
        println("Налито $amount воды, всего: $waterAmount")
    }

    override fun getWater(amount: Int) {
        if (waterAmount < amount) {
            println("Недостаточно воды")
            return
        }
        waterAmount -= amount
        println("Выдано $amount воды")
    }
}
class WashingMachin(
    val capacity: Int,
    override val maxTemperature: Int = 90
) : TemperatureOpenableEquipment(), WaterConnection, Drainable {

    override fun connectToWaterSupply() {
        println("Подключено к водопроводу")
    }

    override fun getWater(amount: Int) {
        println("Набрано $amount воды")
    }

    override fun connectToDrain() {
        println("Подключено к канализации")
    }

    override fun drain() {
        println("Вода слита")
    }
}
class Kettle(
    override val maxTemperature: Int = 100
) : TemperatureOpenableEquipment(), WaterContainer {

    override val capacity: Int = 2
    private var waterAmount: Int = 0

    override fun fillWater(amount: Int) {
        waterAmount += amount
        println("Налито $amount воды, всего: $waterAmount")
    }

    override fun getWater(amount: Int) {
        if (waterAmount < amount) {
            println("Недостаточно воды")
            return
        }
        waterAmount -= amount
        println("Выдано $amount воды")
    }
}
class Oven(
    override val maxTemperature: Int = 250
) : TemperatureOpenableEquipment(), Timable {

    override fun setTimer(time: Int) {
        if (!isPoweredOn) {
            println("Невозможно установить таймер: устройство выключено")
            return
        }
        println("Таймер установлен на $time минут")
    }
}

fun main() {
    println("=== Холодильник ===")
    val fridge = Refrigerat(capacity = 300)
    fridge.powerOn()
    fridge.open()
    fridge.setTemperature(5)
    fridge.fillWater(10)
    fridge.getWater(3)
    fridge.programAction("Режим суперзаморозки")
    fridge.execute()
    fridge.close()
    fridge.powerOff()
    fridge.setTemperature(3) // ожидаемо: устройство выключено

    println("\n=== Стиральная машина ===")
    val washer = WashingMachin(capacity = 6)
    washer.powerOn()
    washer.connectToWaterSupply()
    washer.getWater(20)
    washer.setTemperature(60)
    washer.programAction("Стирка хлопка")
    washer.execute()
    washer.drain()
    washer.powerOff()

    println("\n=== Чайник ===")
    val kettle = Kettle()
    kettle.fillWater(2)
    kettle.powerOn()
    kettle.setTemperature(100)
    kettle.programAction("Кипячение")
    kettle.execute()
    kettle.getWater(1)
    kettle.powerOff()
    kettle.programAction("Кипячение") // ожидаемо: устройство выключено

    println("\n=== Духовка ===")
    val oven = Oven()
    oven.powerOn()
    oven.open()
    oven.setTemperature(180)
    oven.setTimer(30)
    oven.programAction("Выпечка")
    oven.execute()
    oven.close()
    oven.powerOff()
}