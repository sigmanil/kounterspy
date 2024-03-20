package dev.kounterspy

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.datasource")
data class SpringDataSourceProperties(
    val url: String,
    val username: String,
    val password: String,
    val driverClassName: String
)