package com.smatepreview.smatepreview.controller

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.domain.Stauts
import com.smatepreview.smatepreview.dto.*
import com.smatepreview.smatepreview.dto.RequestParam
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

    @GetMapping("/resttemplate/getData")
    fun findData(@RequestBody search: SearchCondition): Api? {

        return apiService.search(search)

    }





    @PostMapping("/status")
    fun statusTest(): StatusResponseDto? {

        val request = StatusRequestDto(listOf("2118677762"))

        return apiService.gettingStatusApi(request)

    }

    @GetMapping("/status/find")
    fun findStatus(@RequestBody statusRequestDto: StatusRequestDto): Stauts? {

        return apiService.findStatus(statusRequestDto)

    }

}