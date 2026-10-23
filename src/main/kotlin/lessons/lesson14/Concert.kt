package lessons.lesson14

//Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”.
// Добавьте метод, который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.
class Concert(
    val group: String,
    val place: String,
    val price: Double,
    val count: Int) {
    private var ticket: Int = 0
    fun concertInfo(){
        println("Группа: $group")
        println("Место: $place")
        println("Цена: $price")
        println("Вместимость: $count")
        println("Продано билетов: $ticket")
    }
    fun buyTicket(){
        ticket++
    }
}