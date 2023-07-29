package ru.rapidbit.telegramsvc.config

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.rapidbit.telegramsvc.config.properties.TelegramSvcProperties

@Configuration
class RabbitConfiguration(private val props: TelegramSvcProperties) {

    @Bean
    fun simpleContainerFactory(connectionFactory: ConnectionFactory): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory)
        factory.setMessageConverter(Jackson2JsonMessageConverter())
        return factory
    }

    @Bean
    fun queueSendMessage(amqpAdmin: AmqpAdmin) : Queue {
        return createQueue(amqpAdmin, props.queueSendMessage)
    }

    @Bean
    fun queueSendPhoto(amqpAdmin: AmqpAdmin) : Queue {
        return createQueue(amqpAdmin, props.queueSendPhoto)
    }

    @Bean
    fun queueSendSticker(amqpAdmin: AmqpAdmin) : Queue {
        return createQueue(amqpAdmin, props.queueSendSticker)
    }

    fun createQueue(amqpAdmin: AmqpAdmin, queueName: String) : Queue {
        val queue = QueueBuilder.durable(queueName)
            .build()
        amqpAdmin.declareQueue(queue)
        return queue
    }

}