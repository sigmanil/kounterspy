package dev.kounterspy.repository

import dev.kounterspy.repository.model.AuthorEntity
import dev.kounterspy.repository.queries.AuthorQueries
import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class AuthorDao(val jdbcClient: JdbcClient) {

  private val queries = AuthorQueries()

  @Transactional
  fun findAll(): List<AuthorEntity> {
    return jdbcClient
      .sql(queries.findAll)
      .query(AuthorEntity::class.java)
      .list()
  }
}

