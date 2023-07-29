package ru.rapidbit.telegramsvc.client

import org.springframework.core.io.Resource

interface TelegramApiClient {

    fun sendMessage(chatId: String, text: String)
    fun sendPhoto(chatId: String, caption: String, photo: Resource)

    fun sendSticker(chatId: String, sticker: String)

}