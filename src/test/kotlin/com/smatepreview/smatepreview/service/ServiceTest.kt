package com.smatepreview.smatepreview.service

import com.smatepreview.smatepreview.dto.*
import com.smatepreview.smatepreview.repository.ApiRepository
import com.smatepreview.smatepreview.repository.ApiRepositoryStub
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*

@SpringBootTest
class ServiceTest(
    val apiService: ApiService
) {

    @MockBean
    lateinit var apiRepository: ApiRepository

    @BeforeEach
    fun presave() {



    }


    @Test
    @DisplayName("Service에 사업자 번호 insert 후 repository로 save 호출되는지 확인")
    fun saveInfo() {

        //GIVEN   where 조건의 값

            val response = ResponseDto(
                    requestCnt = 1,
                    listOf(
                        Data(
                            RequestParam(
                                "2118677762",
                                "손석민",
                                "1101112250598"
                            )
                        )
                    )
            )

        //WHEN    테이블에 들어가는 데이터 상태

        //THEN    테스트 결과

            apiService.saveData(response);
            verify(apiRepository, times(1)).save(any())
    }

    @AfterEach
    fun deleteAll() {
        apiRepository.deleteAll()
    }

}

