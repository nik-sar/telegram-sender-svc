package ru.rapidbit.telegramsvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TelegramSvcApplication

fun main(args: Array<String>) {
	runApplication<TelegramSvcApplication>(*args)
}
