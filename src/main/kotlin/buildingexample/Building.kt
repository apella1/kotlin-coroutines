package me.apella.buildingexample

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

enum class Product(val description: String, val deliveryTime: Long) {
    DOORS("doors", 750),
    WINDOWS("windows", 1_250)
}

suspend fun order(item: Product): Product {
    println("Order en route >>> The ${item.description} are on their way!")
    delay(item.deliveryTime)
    println("Order delivered >>> Your ${item.description} have arrived!")
    return item
}

suspend fun perform(taskName: String) {
    println("Starting task >>> $taskName")
    delay(1_000)
    println(
        "Task completed >>> $taskName"
    )
}

fun main() {
    runBlocking {
        val windows = async { order(Product.WINDOWS) }
        val doors = async { order(Product.DOORS) }

        launch {
            perform("laying bricks")
            perform("installing ${windows.await().description}")
            perform("installing ${doors.await().description}")
        }
    }

}