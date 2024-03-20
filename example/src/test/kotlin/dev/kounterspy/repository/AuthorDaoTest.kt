package dev.kounterspy.repository

import dev.kounterspy.config.PsqlContainer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AuthorDaoTest : PsqlContainer() {

  @Autowired
  private lateinit var authorDao: AuthorDao

  @Test
  fun `should return all authors - which is zero`() {
    val fruits = authorDao.findAll()
    assertThat(fruits).isEmpty()
  }
}