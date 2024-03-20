package dev.kounterspy.repository

import dev.kounterspy.config.PsqlContainer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
class BookDaoTest : PsqlContainer() {

  @Autowired
  private lateinit var bookDao: BookDao

  @Test
  fun `should return all cars - which is zero`() {
    val fruits = bookDao.findAll()
    assertThat(fruits).isEmpty()
  }
}