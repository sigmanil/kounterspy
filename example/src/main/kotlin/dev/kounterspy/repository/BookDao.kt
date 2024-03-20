package dev.kounterspy.repository

import dev.kounterspy.repository.model.BookEntity
import dev.kounterspy.repository.model.BookEntityMapper
import dev.kounterspy.repository.queries.BookQueries
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource

@Repository
class BookDao(dataSource: DataSource) {

  private val template = NamedParameterJdbcTemplate(dataSource)
  private val queries = BookQueries()
  private val rowMapper = BookEntityMapper()

  @Transactional
  fun findAll(): List<BookEntity> {
    return template.query(queries.findAll, rowMapper)
  }
}