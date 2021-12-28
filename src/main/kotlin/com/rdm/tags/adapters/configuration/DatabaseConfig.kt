package com.rdm.tags.adapters.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class DatabaseConfig {

    @Value("\${database.config.url}")
    private val url: String? = null

    @Value("\${database.config.username}")
    private val username: String? = null

    @Value("\${database.config.password}")
    private val password: String? = null

    @Bean
    fun getDataSource(): DataSource? {
        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.url(url)
        dataSourceBuilder.username(username)
        dataSourceBuilder.password(password)
        return dataSourceBuilder.build()
    }
}