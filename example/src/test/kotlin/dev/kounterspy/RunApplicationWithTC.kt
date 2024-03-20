package dev.kounterspy

import dev.kounterspy.config.LocalDevTestcontainersConfig
import org.springframework.boot.fromApplication

// Runs the application with TestContainers
class RunApplicationWithTC {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      fromApplication<KounterspyApplication>()
        .with(LocalDevTestcontainersConfig::class.java)
        .run(*args)
    }
  }
}