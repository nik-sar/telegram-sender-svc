package ru.rapidbit.telegramsvc.client.request

import com.fasterxml.jackson.annotation.JsonProperty

data class TelegramStickerRequest(

    @field:JsonProperty("chat_id")
    val chatId: String,

    @field:JsonProperty("sticker")
    val text: String

)
