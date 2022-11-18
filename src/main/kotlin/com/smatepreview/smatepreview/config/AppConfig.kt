package com.smatepreview.smatepreview.config

import com.smatepreview.smatepreview.service.ApiService
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class AppConfig {
    @Bean
    fun restTemplate() : RestTemplate {
        return RestTemplate();
    }

}