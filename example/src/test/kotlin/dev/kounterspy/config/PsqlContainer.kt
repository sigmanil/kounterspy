package dev.kounterspy.config

import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
abstract class PsqlContainer {

  companion object {
    class KGenericContainer(imageName: String) : PostgreSQLContainer<KGenericContainer>(imageName)

    @Container
    @ServiceConnection
    val postgres: PostgreSQLContainer<*> = KGenericContainer("postgres:16.1")
      .withInitScript("db/init_postgre.sql")
      .withExposedPorts(5432)
      .withDatabaseName("test")
      .withUsername("test")
      .withPassword("test")
      .withReuse(true)
  }
}