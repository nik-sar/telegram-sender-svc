package ru.rapidbit.telegramsvc.client

import org.springframework.core.io.Resource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import ru.rapidbit.telegramsvc.client.request.TelegramMessageRequest
import ru.rapidbit.telegramsvc.client.request.TelegramStickerRequest
import ru.rapidbit.telegramsvc.config.properties.TelegramSvcProperties

@Component
class TelegramApiClientImpl(
    private val restTemplate: RestTemplate,
    private val props: TelegramSvcProperties
) : TelegramApiClient {

    override fun sendMessage(chatId: String, text: String) {
        val requestData = TelegramMessageRequest(chatId, text)
        exchange(requestData, "sendMessage")
    }

    override fun sendPhoto(chatId: String, caption: String, photo: Resource) {
        val headers = HttpHeaders()
        headers.contentType = MediaType.MULTIPART_FORM_DATA
        val uri = createURI("sendPhoto")
        val body = LinkedMultiValueMap<String, Any>()
        body.add("chat_id", chatId)
        body.add("photo", photo);
        body.add("caption", caption)
        val entity = HttpEntity(body, headers)
        restTemplate.exchange(uri, HttpMethod.POST, entity, String::class.java)
    }

    override fun sendSticker(chatId: String, sticker: String) {
        val requestData = TelegramStickerRequest(chatId, sticker)
        exchange(requestData, "sendSticker")
    }

    private fun createURI(telegramCommand: String) = UriComponentsBuilder.fromHttpUrl(props.url)
        .buildAndExpand(props.token, telegramCommand)
        .toUri()

    private fun <T> exchange(requestData: T, telegramCommand: String) {
        val uri = createURI(telegramCommand)
        val entity = HttpEntity(requestData, HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        })
        restTemplate.exchange(uri, HttpMethod.POST, entity, String::class.java)
    }

}