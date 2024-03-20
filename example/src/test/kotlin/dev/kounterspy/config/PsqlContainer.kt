package dev.kounterspy.config

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

// Auto rollback for each test
@DataJpaTest(showSql = true)
// Does not replace the testcontainer data source. Possibly wrong configuration. Matches DataJpaTest annotation
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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