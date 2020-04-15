package io.github.alexoooo.sample.proj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux


@EnableWebFlux
@SpringBootApplication
class ProjApp



fun main(args: Array<String>) {
    runApplication<ProjApp>(*args)
}