package ru.rapidbit.telegramsvc.service

import org.springframework.stereotype.Service
import ru.rapidbit.telegramsvc.dto.TelegramSvcMessageDto
import ru.rapidbit.telegramsvc.dto.TelegramSvcPhotoDto
import ru.rapidbit.telegramsvc.dto.TelegramSvcStickerDto

@Service
interface TelegramSenderService {

    fun sendMessage(message: TelegramSvcMessageDto)
    fun sendPhoto(message: TelegramSvcPhotoDto)
    fun sendSticker(message: TelegramSvcStickerDto)

}