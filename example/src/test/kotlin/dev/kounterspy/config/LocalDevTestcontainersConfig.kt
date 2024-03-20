package dev.kounterspy.config

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer

@TestConfiguration(proxyBeanMethods = false)
class LocalDevTestcontainersConfig {

  @Bean
  @ServiceConnection
  fun postgresContainer(): PostgreSQLContainer<*> {
    return PostgreSQLContainer<Nothing>("postgres:16.1")
      .withInitScript("db/init_postgre.sql")
  }
}