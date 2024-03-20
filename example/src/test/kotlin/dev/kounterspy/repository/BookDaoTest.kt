package dev.kounterspy.repository

import dev.kounterspy.config.PsqlContainer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class BookDaoTest(@Autowired private val bookDao: BookDao) : PsqlContainer() {

  @Test
  fun `should return all cars - which is zero`() {
    val books = bookDao.findAll()
    assertThat(books).isEmpty()
  }
}