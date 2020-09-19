package io.github.alexoooo.sample.proj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux


@EnableWebFlux
@SpringBootApplication
class ProjApp


fun main(args: Array<String>) {
//    var myList = persistentListOf<Int>()
//
//    val start = System.currentTimeMillis()
//
//    for (i in 0 .. 10_000) {
//        myList = myList.add(i)
//    }
//
//    for (j in 0 .. 10_000) {
//        myList = myList.set((Math.random() * myList.size).toInt(), j)
//    }
//
//    println("took: " + (System.currentTimeMillis() - start))

    runApplication<ProjApp>(*args)
}