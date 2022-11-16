package com.smatepreview.smatepreview.controller

import com.smatepreview.smatepreview.dto.BusinessInfo
import com.smatepreview.smatepreview.dto.RequestDto
import com.smatepreview.smatepreview.dto.ResponseDto
import com.smatepreview.smatepreview.service.ApiService
import org.springframework.http.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory


@RestController
// var ==> variable
// val => value
class RestTemplateController(val restTemplate: RestTemplate, val apiService: ApiService) {

    @GetMapping("/resttemplate")
    fun restTemplateTest(): String {
        val header = HttpHeaders()
        header.contentType = MediaType.APPLICATION_JSON

        val request = RequestDto(
            listOf(
                BusinessInfo(
                    "2118677762",
                    "20010612",
                    "손석민",
                    "",
                    "(주)폴리큐브",
                    "1101112250598",
                    "",
                    ""
                )
            )
        )

        val entity: HttpEntity<*> = HttpEntity<RequestDto>(request, header)
        val url = "http://api.odcloud.kr/api/nts-businessman/v1/validate"

        val defaultUriBuilderFactory = DefaultUriBuilderFactory("http://api.odcloud.kr/api/nts-businessman/v1/validate")
        defaultUriBuilderFactory.encodingMode = DefaultUriBuilderFactory.EncodingMode.NONE
        val build =
            defaultUriBuilderFactory.builder()
                .queryParam("serviceKey", "VU2wvwgzw2TjYrvH%2FCdTQFmI7vn8rh4yNog9eSBCRPeg473G8%2F%2BMcwGZQbHluVTOyOSr2c0MoGUdFwOPm9a6mg%3D%3D")
                .queryParam("returnType", "JSON")
                .build()

        val exchange = restTemplate.exchange(
            build,
            HttpMethod.POST,
            entity,
            ResponseDto::class.java
        )

        exchange.body?.also {
            apiService.saveData(it)
        }

        println("exchange = $exchange")

        return exchange.body.toString()
    }


}