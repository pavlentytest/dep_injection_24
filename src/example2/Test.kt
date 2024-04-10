package example2

// https://androidschool.ru/2020/05/27/dependency-injection-or-service-locator/

class Engine {
    fun start() {

    }
}
class CarA {
    private val engine = Engine()
    fun start() {
        engine.start()
    }
}
fun mainA() {
    val car = CarA()
    car.start()

}

class CarB(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}
// Класс CarA инициализирует полеEngineсамостоятельно, в то время, как класс
// CarB просто использует переданный извне объект класса Engine.
// То есть, получается что внедрение зависимости – это подход, при котором класс или какая-то другая сущность
// может использовать любой экземпляр нужного объекта извне, не создавая самостоятельно.
// Короче говоря, класс не должен знать как создать необходимый ему экземпляр
// (то есть объект от которого он зависит) – а должен просто использовать переданную извне зависимость.
fun main_B() {
    val engine = Engine()
    val car = CarB(engine)
    car.start()
    val gas_engie = Engine()
    val car_g = CarB(engine)
    car_g.start()
}

//  какие есть способы внедрения зависимостей (DI) в Android:
//
//Внедрение зависимости через конструктор (Constructor Injection).
// Этот способ мы рассмотрели выше. В этом способе нужно передать необходимую зависимость в конструктор.
//Внедрение зависимости через поле. (Field Injection (or Setter Injection)).
// Некоторые класс из Android framework такие как Activity или Fragments создаются системой,
// так что первый способ использовать нельзя. Внедрение зависимости через поле позволяет передать зависимость
// уже после того как класс будет создан. Примерно это будет выглядеть вот так:

class Car {
    lateinit var engine: Engine
    fun start() {
        engine.start()
    }
}
fun main() {
    val car = Car()
    car.engine = Engine()
    car.start()
}