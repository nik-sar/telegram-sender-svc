package ru.rapidbit.telegramsvc.config.properties

import org.jetbrains.annotations.NotNull
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "telegram-svc")
data class TelegramSvcProperties(

    @field:NotNull
    val queueSendMessage: String,

    @field:NotNull
    val queueSendPhoto: String,

    @field:NotNull
    val queueSendSticker: String,

    @field:NotNull
    val token: String,

    @field:NotNull
    val url: String

)
