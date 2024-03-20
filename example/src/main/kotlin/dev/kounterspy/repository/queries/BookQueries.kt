package dev.kounterspy.repository.queries

class BookQueries {
  val findAll: String =
    """
      |SELECT *
      |FROM book
    """.trimMargin()
}
