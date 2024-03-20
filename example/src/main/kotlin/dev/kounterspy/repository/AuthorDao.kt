package dev.kounterspy.repository

import dev.kounterspy.repository.model.AuthorEntity
import dev.kounterspy.repository.queries.AuthorQueries
import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.stereotype.Repository

@Repository
class AuthorDao(val jdbcClient: JdbcClient) {

  private val queries = AuthorQueries()

  fun findAll(): List<AuthorEntity> {
    return jdbcClient
      .sql(queries.findAll)
      .query(AuthorEntity::class.java)
      .list()
  }
}

