package com.smatepreview.smatepreview.service

import com.smatepreview.smatepreview.dto.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.kotlin.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class ServiceTest {

    @Autowired
    lateinit var apiService: ApiService

    @BeforeEach
    fun presave() {
    }

    @Test
    @DisplayName("data 가 올바르게 호출되는지 여부 확인")
    fun saveInfo() {
        //GIVEN   where 조건의 값
        val data = Data(
            RequestParam(
                "2118677762",
                "손석민",
                "1101112250598"
            )
        )

        //WHEN    테이블에 들어가는 데이터 상태
        val gettingDataApi = apiService.gettingDataApi(RequestDto(
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
        ))

        //THEN    테스트 결과
        assertAll({
            gettingDataApi?.data?.forEach {
                assertEquals(data.request_param.b_no, it.request_param.b_no)
                assertEquals(data.request_param.p_nm, it.request_param.p_nm)
                assertEquals(data.request_param.corp_no, it.request_param.corp_no)
            }
        })
    }

    @AfterEach
    fun deleteAll() {
//        apiRepository.deleteAll()
    }

}

