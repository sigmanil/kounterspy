package dev.kounterspy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@SpringBootTest
class KounterspyApplicationTests(@Qualifier("myJdbcTemplate") val jdbc: NamedParameterJdbcTemplate) {

    @Test
    fun contextLoads() {
    }

    @Test
    fun testConnection() {
        val actual: List<Int> = jdbc.query("SELECT 1") { rs, _ -> rs.getInt(1) }
        Assertions.assertEquals(listOf(1), actual)
    }
}
