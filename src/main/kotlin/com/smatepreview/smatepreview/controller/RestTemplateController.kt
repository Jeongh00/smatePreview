package com.smatepreview.smatepreview.controller

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.dto.BusinessInfo
import com.smatepreview.smatepreview.dto.RequestDto
import com.smatepreview.smatepreview.dto.RequestParam
import com.smatepreview.smatepreview.dto.ResponseDto
import com.smatepreview.smatepreview.service.ApiService
import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class RestTemplateController(
    val apiService: ApiService) {

    @PostMapping("/resttemplate")
    fun restTemplateTest(): ResponseDto? {

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

        return apiService.gettingDataApi(request)

    }

    @GetMapping("/resttemplate/find/{api_id}")
    fun findData(@PathVariable("api_id") apiId: Long): Optional<Api> {

        return apiService.findData(apiId)

    }

    @PutMapping("/resttemplate/update/{api_id}")
    fun updateReview(@RequestBody request: RequestParam, @PathVariable("api_id") apiId: Long): Api {
        return apiService.updateById(apiId, request)
    }

}