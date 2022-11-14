package com.smatepreview.smatepreview.service

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.repository.ApiRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
@RequiredArgsConstructor
class ApiService (val apiRepository: ApiRepository) {

    @Transactional
    fun saveData(entity: Api) {
        apiRepository.save(entity)
    }

}