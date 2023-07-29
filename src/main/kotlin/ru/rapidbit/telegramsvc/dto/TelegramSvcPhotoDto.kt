package ru.rapidbit.telegramsvc.dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TelegramSvcPhotoDto @JsonCreator constructor(

    @JsonProperty("userId")
    val userId: String,

    @JsonProperty("photo")
    val photo: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("caption")
    val caption: String?,

)
