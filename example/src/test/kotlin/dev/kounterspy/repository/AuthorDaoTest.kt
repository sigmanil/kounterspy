package dev.kounterspy.repository

import dev.kounterspy.config.PsqlContainer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class AuthorDaoTest(@Autowired private val authorDao: AuthorDao) : PsqlContainer() {

  @Test
  fun `should return all authors - which is zero`() {
    val authors = authorDao.findAll()
    assertThat(authors).isEmpty()
  }
}