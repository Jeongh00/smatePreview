package com.smatepreview.smatepreview.service

import com.smatepreview.smatepreview.repository.ApiRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
@RequiredArgsConstructor
class ApiService {

    private val ApiRepository: ApiRepository? = null

    @Transactional
    fun join(api: api?) {
        ApiRepository.save(api)
    }

//
//    @Autowired
//    lateinit var apiRepository: apiRepository
//
//    fun getData(): List<ReadDataDTO> {
//        val data = apiRepository.findAll()
//        return data.map
//    }

}