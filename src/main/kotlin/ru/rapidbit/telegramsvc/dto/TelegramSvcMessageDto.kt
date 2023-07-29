package ru.rapidbit.telegramsvc.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TelegramSvcMessageDto @JsonCreator constructor(

    @JsonProperty("userId")
    val userId: String,

    @JsonProperty("message")
    val message: String

)
