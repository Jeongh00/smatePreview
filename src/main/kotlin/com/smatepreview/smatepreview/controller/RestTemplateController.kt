package com.smatepreview.smatepreview.controller

//import com.smatepreview.smatepreview.service.ApiService
import com.smatepreview.smatepreview.dto.BusinessInfo
import com.smatepreview.smatepreview.dto.RequestDto
import com.smatepreview.smatepreview.service.ApiService
import org.apache.tomcat.util.json.JSONParser
import org.json.JSONArray
import org.json.JSONObject
import org.json.XML
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.http.*
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import org.yaml.snakeyaml.util.UriEncoder
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets
import java.time.Duration


@RestController
class RestTemplateController(val restTemplate: RestTemplate) {

    @GetMapping("/resttemplate")
    fun restTemplateTest(): ResponseEntity<Any> {
        val header = HttpHeaders()
        header.contentType = MediaType.APPLICATION_JSON

        val request: RequestDto = RequestDto(
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
        val uri = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("serviceKey", "jEKFnBOlU3a3LV%2BEXj8seLQw2qEZjmtipFCN8PmCeSNNE3PsbU90BXTDdDuDXY7X6TE%2B15pNOOxVcQXnKyZ9AQ%3D%3D")
            .queryParam("returnType", "JSON")
            .build()

        println(uri.toString())

        println(UriEncoder.encode("VU2wvwgzw2TjYrvH%2FCdTQFmI7vn8rh4yNog9eSBCRPeg473G8%2F%2BMcwGZQbHluVTOyOSr2c0MoGUdFwOPm9a6mg%3D%3D"))

        val exchange = restTemplate.exchange(
            uri.toString(),
            HttpMethod.POST,
            entity,
            Any::class.java
        )

        println("exchange = $exchange")
        val statusCode: HttpStatus = exchange.statusCode //상태코드확인
        val headers = exchange.headers //헤더정보확인
        val body = exchange.body //바디정보확인

        return exchange
    }

//    @PostMapping("/send")
//    fun send(@RequestBody @Validated request: apiRequest): api? {
//
//        val api = api()
//
//        api.setTitle(request.getTitle())
//
//        ApiService.join(api)
//
//        return api
//    }

}