interface Engine
class DefaultEngine: Engine

class Car {
    private val engine: Engine = DefaultEngine()
}

fun main() {
    val car = Car()
}