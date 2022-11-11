package com.smatepreview.smatepreview.controller

import com.smatepreview.smatepreview.service.ApiService
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.http.*
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.time.Duration


@RestController
class RestTemplateController(val restTemplate: RestTemplate) {

    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate? {
        return restTemplateBuilder
            .requestFactory {
                BufferingClientHttpRequestFactory(
                    SimpleClientHttpRequestFactory()
                )
            }
            .setBufferRequestBody(false)
            .setConnectTimeout(Duration.ofMillis(5000))
            .setReadTimeout(Duration.ofMillis(5000))
            .additionalMessageConverters(MappingJackson2HttpMessageConverter())
            .build()
    }

    @GetMapping("/resttemplate")
    fun restTemplateTest(): ResponseEntity<Any> {
        val header = HttpHeaders()
        val entity: HttpEntity<*> = HttpEntity<Any>(header)
        val url = "http://api.odcloud.kr/api/nts-businessman/v1/validate"
        val uri = UriComponentsBuilder.fromHttpUrl("$url?serviceKey=jEKFnBOlU3a3LV%2BEXj8seLQw2qEZjmtipFCN8PmCeSNNE3PsbU90BXTDdDuDXY7X6TE%2B15pNOOxVcQXnKyZ9AQ%3D%3D&returnType=JSON").build()
        val exchange = restTemplate.exchange(
            uri.toString(), HttpMethod.GET, entity,
            Any::class.java
        )

        println("exchange = $exchange")
        val statusCode: HttpStatus = exchange.statusCode //상태코드확인
        val headers = exchange.headers //헤더정보확인
        val body = exchange.body //바디정보확인

        return exchange
    }

    @PostMapping("/send")
    fun send(@RequestBody @Validated request: apiRequest): api? {

        val api = api()

        api.setTitle(request.getTitle())

        ApiService.join(api)

        return api
    }


}