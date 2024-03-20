package dev.kounterspy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(SpringDataSourceProperties::class)
class KounterspyApplication

fun main(args: Array<String>) {
	runApplication<KounterspyApplication>(*args)
}
