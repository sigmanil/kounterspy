package dev.kounterspy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KounterspyApplication

fun main(args: Array<String>) {
	runApplication<KounterspyApplication>(*args)
}
