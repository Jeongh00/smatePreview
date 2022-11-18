package com.smatepreview.smatepreview

import com.smatepreview.smatepreview.service.ApiService
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@SpringBootApplication
class SmatePreviewApplication

fun main(args: Array<String>) {
    runApplication<SmatePreviewApplication>(*args)
}