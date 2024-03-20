package dev.kounterspy.repository.model

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

data class BookEntity(
  val id: Long?,
  val name: String,
)

class BookEntityMapper : RowMapper<BookEntity> {
  override fun mapRow(rs: ResultSet, rowNum: Int): BookEntity? {
    return try { BookEntity(
        id = rs.getLong("id"),
        name = rs.getString("name"),
      )
    } catch (e: Exception) {
      null
    }
  }
}