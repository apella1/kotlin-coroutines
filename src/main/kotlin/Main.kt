package me.apella

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {
    // hierarchy of coroutines -> runBlocking creates nested launch coroutines
    runBlocking {
        launch {
            println("Sledge: Suplex")
            tagOut()
            println("Sledge: F4 Leglock")
            tagOut()
            println("Sledge: Pinning 1,2,3")
        }

        launch {
            println("Hammer: Clothesline")
            tagOut()
            println("Hammer: Piledriver")
        }

    }
}

suspend fun tagOut() {
    println("Tagging out!")
    yield()
}