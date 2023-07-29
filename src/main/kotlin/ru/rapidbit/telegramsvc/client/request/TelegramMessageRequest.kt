package ru.rapidbit.telegramsvc.client.request

import com.fasterxml.jackson.annotation.JsonProperty

data class TelegramMessageRequest (

    @field:JsonProperty("chat_id")
    val chatId: String,

    @field:JsonProperty("text")
    val text: String

)
