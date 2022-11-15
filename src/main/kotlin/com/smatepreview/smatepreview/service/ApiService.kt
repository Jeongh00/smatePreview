package com.smatepreview.smatepreview.service

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.dto.Data
import com.smatepreview.smatepreview.dto.ResponseDto
import com.smatepreview.smatepreview.repository.ApiRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.util.function.Consumer
import javax.transaction.Transactional

@Service
@Transactional
@RequiredArgsConstructor
class ApiService (val apiRepository: ApiRepository) {

    @Transactional
    fun saveData(dto: ResponseDto) {
        dto.data.save()
//        apiRepository.save(Api(null, dto.data[0].request_param.b_no, dto.data[0].request_param.p_nm, dto.data[0].request_param.corp_no))
    }

    fun List<Data>.save() {
        this.forEach {
            apiRepository.save(Api(null, it.request_param.b_no, it.request_param.p_nm, it.request_param.corp_no))
        }
    }
}
