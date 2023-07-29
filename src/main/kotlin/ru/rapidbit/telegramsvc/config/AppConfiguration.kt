package ru.rapidbit.telegramsvc.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import ru.rapidbit.telegramsvc.config.properties.TelegramSvcProperties

@EnableConfigurationProperties(value = [TelegramSvcProperties::class])
@Configuration
class AppConfiguration {

    @Bean
    fun createRestTemplate(restTemplateBuilder: RestTemplateBuilder) : RestTemplate {
        return restTemplateBuilder.build()
    }

}