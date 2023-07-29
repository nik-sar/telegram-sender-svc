package ru.rapidbit.telegramsvc.service

import org.springframework.core.io.ByteArrayResource
import org.springframework.stereotype.Service
import ru.rapidbit.telegramsvc.client.TelegramApiClient
import ru.rapidbit.telegramsvc.dto.TelegramSvcMessageDto
import ru.rapidbit.telegramsvc.dto.TelegramSvcPhotoDto
import ru.rapidbit.telegramsvc.dto.TelegramSvcStickerDto
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@Service
class TelegramSenderServiceImpl(private val client: TelegramApiClient) : TelegramSenderService {

    override fun sendMessage(message: TelegramSvcMessageDto) {
        client.sendMessage(message.userId, message.message)
    }

    @OptIn(ExperimentalEncodingApi::class)
    override fun sendPhoto(message: TelegramSvcPhotoDto) {
        val data = Base64.decode(message.photo)
        val photo = object : ByteArrayResource(data) {
            override fun getFilename(): String {
                return message.name
            }
        }
        client.sendPhoto(message.userId, message.caption, photo)
    }

    override fun sendSticker(message: TelegramSvcStickerDto) {
        client.sendSticker(message.userId, message.sticker)
    }

}