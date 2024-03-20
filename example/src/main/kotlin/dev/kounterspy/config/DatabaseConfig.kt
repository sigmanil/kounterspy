package dev.kounterspy.config

import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel.INFO
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Configuration
class DatabaseConfig {
    @Bean
    fun myDataSource(dataSourceProperties: SpringDataSourceProperties): DataSource {
        val actualDataSource = DataSourceBuilder.create()
            .url(dataSourceProperties.url)
            .username(dataSourceProperties.username)
            .password(dataSourceProperties.password)
            .driverClassName(dataSourceProperties.driverClassName)
            .build()

        return ProxyDataSourceBuilder.create(actualDataSource)
            .logQueryBySlf4j(INFO)
            .countQuery()
            .proxyResultSet()
            .buildProxy()
    }

    @Bean
    fun myJdbcTemplate(@Qualifier("myDataSource") dataSource: DataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }
}