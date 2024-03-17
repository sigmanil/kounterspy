package dev.kounterspy.repository.dao

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

data class BookEntity(
  val id: Int?,
  val name: String,
)

class BookEntityMapper : RowMapper<BookEntity> {
  override fun mapRow(rs: ResultSet, rowNum: Int): BookEntity? {
    return BookEntity(
      id = rs.getInt("id"),
      name = rs.getString("name"),
    )
  }
}