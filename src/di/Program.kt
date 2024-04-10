package di

import DefaultEngine
import Engine

class Car(private val engine: Engine)

fun main() {
    // Всё просто – класс Car не знает, откуда приходит реализация Engine,
    // при этом заменить эту самую реализацию легко, достаточно передать её в конструктор.

    val car = Car(DefaultEngine())

}