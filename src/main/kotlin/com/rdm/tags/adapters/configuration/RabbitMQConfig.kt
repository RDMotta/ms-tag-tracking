package com.rdm.tags.adapters.configuration

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitMQConfig {

    @Value("\${spring.rabbitmq.queue}")
    private val queue: String? = null

    @Value("\${rabbitmq.uri}")
    private val uri: String? = null

    @Bean
    fun rabbitConnectionFactory(): ConnectionFactory? {
        val connectionFactory = CachingConnectionFactory()
        connectionFactory.setUri(uri!!)
        return connectionFactory
    }

    @Bean
    fun queue(): Queue? {
        return Queue(queue, true)
    }

    @Bean
    fun messageConverter(): Jackson2JsonMessageConverter? {
        return Jackson2JsonMessageConverter()
    }
}