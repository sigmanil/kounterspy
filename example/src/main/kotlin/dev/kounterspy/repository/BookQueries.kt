package dev.kounterspy.repository

class BookQueries {
  val findAll: String =
    """
      |SELECT *
      |FROM book
    """.trimMargin()
}
