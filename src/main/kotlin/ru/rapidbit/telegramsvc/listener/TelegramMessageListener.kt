package ru.rapidbit.telegramsvc.listener

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import ru.rapidbit.telegramsvc.dto.TelegramSvcMessageDto
import ru.rapidbit.telegramsvc.dto.TelegramSvcPhotoDto
import ru.rapidbit.telegramsvc.dto.TelegramSvcStickerDto
import ru.rapidbit.telegramsvc.service.TelegramSenderService
import java.util.function.Consumer

@Component
class TelegramMessageListener(private val service: TelegramSenderService) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(TelegramMessageListener::class.java)
    }

    @RabbitListener(queues = ["#{queueSendMessage.name}"], containerFactory = "simpleContainerFactory")
    fun receivedMessage(data: TelegramSvcMessageDto) {
        handle(data, service::sendMessage)
    }

    @RabbitListener(queues = ["#{queueSendPhoto.name}"], containerFactory = "simpleContainerFactory")
    fun receivedPhoto(data: TelegramSvcPhotoDto) {
        handle(data, service::sendPhoto)
    }

    @RabbitListener(queues = ["#{queueSendSticker.name}"], containerFactory = "simpleContainerFactory")
    fun receivedSticker(data: TelegramSvcStickerDto) {
        handle(data, service::sendSticker)
    }

    private fun <T> handle(data: T, method: Consumer<T>) {
        log.info("Received data from queue:")
        log.info("$data")
        method.accept(data)
    }

}