package com.smatepreview.smatepreview.service

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.domain.Stauts
import com.smatepreview.smatepreview.dto.*
import com.smatepreview.smatepreview.repository.ApiRepository
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class ApiService(
    val apiRepository: ApiRepository,
    val restTemplate: RestTemplate
) {

    @Transactional
    fun gettingDataApi(request: RequestDto): ResponseDto? {

        val header = HttpHeaders()
        header.contentType = MediaType.APPLICATION_JSON

        val entity: HttpEntity<*> = HttpEntity<RequestDto>(request, header)
//        val url = "http://api.odcloud.kr/api/nts-businessman/v1/validate"

        val defaultUriBuilderFactory =
            DefaultUriBuilderFactory("http://api.odcloud.kr/api/nts-businessman/v1/validate")
        defaultUriBuilderFactory.encodingMode = DefaultUriBuilderFactory.EncodingMode.NONE
        val build =
            defaultUriBuilderFactory.builder()
                .queryParam(
                    "serviceKey",
                    "VU2wvwgzw2TjYrvH%2FCdTQFmI7vn8rh4yNog9eSBCRPeg473G8%2F%2BMcwGZQbHluVTOyOSr2c0MoGUdFwOPm9a6mg%3D%3D"
                )
                .queryParam("returnType", "JSON")
                .build()

        val exchange = restTemplate.exchange(
            build,
            HttpMethod.POST,
            entity,
            ResponseDto::class.java
        )

        exchange.body?.also {
//            apiService.saveData(it)

            it.data.save()

        }

        return exchange.body
    }

//    @Transactional
//    fun saveData(dto: ResponseDto) {
//        dto.data.save()
////        apiRepository.save(Api(null, dto.data[0].request_param.b_no, dto.data[0].request_param.p_nm, dto.data[0].request_param.corp_no))
//    }

    fun List<Data>.save() {
        this.forEach {
            apiRepository.save(Api(null, it.request_param.b_no, it.request_param.p_nm, it.request_param.corp_no))
        }
    }

    @Transactional
    fun findData(apiId: Long): Optional<Api> {
        return apiRepository.findById(apiId)
    }

    @Transactional
    fun updateById(apiId: Long, request: RequestParam): Api {
        val api = this.apiRepository.findById(apiId).get()
        api.pnm = request.p_nm
        api.bno = request.b_no
        api.corpno = request.corp_no
        return api
    }

    @Transactional
    fun search(search: SearchCondition): Api? {
        return apiRepository.search(search)
    }






    @Transactional
    fun gettingStatusApi(request: StatusRequestDto): StatusResponseDto? {

        val header = HttpHeaders()
        header.contentType = MediaType.APPLICATION_JSON

        val entity: HttpEntity<*> = HttpEntity<StatusRequestDto>(request, header)

        val defaultUriBuilderFactory =
            DefaultUriBuilderFactory("http://api.odcloud.kr/api/nts-businessman/v1/status")
        defaultUriBuilderFactory.encodingMode = DefaultUriBuilderFactory.EncodingMode.NONE

        val build =
            defaultUriBuilderFactory.builder()
                .queryParam(
                    "serviceKey",
                    "VU2wvwgzw2TjYrvH%2FCdTQFmI7vn8rh4yNog9eSBCRPeg473G8%2F%2BMcwGZQbHluVTOyOSr2c0MoGUdFwOPm9a6mg%3D%3D"
                )
                .queryParam("returnType", "JSON")
                .build()

        val exchange = restTemplate.exchange(
            build,
            HttpMethod.POST,
            entity,
            StatusResponseDto::class.java
        )

        exchange.body?.also {
//            apiService.saveData(it)

            it.data.saveStatus()

        }

        return exchange.body
    }

    fun List<Detail>.saveStatus() {
        this.forEach {
            apiRepository.saveStatus(it)
        }
    }

    @Transactional
    fun findStatus(statusRequestDto: StatusRequestDto): Stauts? {
        return apiRepository.searchStatus(statusRequestDto)
    }

}
