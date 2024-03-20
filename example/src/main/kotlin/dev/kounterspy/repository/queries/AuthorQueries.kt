package dev.kounterspy.repository.queries

class AuthorQueries {
  val findAll: String =
    """
      |SELECT *
      |FROM author
    """.trimMargin()
}
