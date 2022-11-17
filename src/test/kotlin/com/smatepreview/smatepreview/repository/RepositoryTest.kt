package com.smatepreview.smatepreview.repository

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.dto.RequestParam
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RepositoryTest {

    @Autowired
    lateinit var apiRepository: ApiRepository

    @Test
    @DisplayName("data들 db에 저장되는지 확인")
    fun assertSaveData() {
//        val apiRepository = ApiRepositoryStub()

        // given
            val requestParam = RequestParam(
                "2118677762",
                "손석민",
                "1101112250598"
            )

        // when
            val (id, _, _, _) = apiRepository.save(
                Api(
                    "2118677762",
                    "손석민",
                    "1101112250598"
                )
            )

        println(id)

        // then
            assertNotNull(id)
            id?.also {
                val savedDataApi = apiRepository.findById(it).get();
                assertNotNull(savedDataApi)
                assertEquals(savedDataApi.bno, requestParam.b_no)
                assertEquals(savedDataApi.pnm, requestParam.p_nm)
                assertEquals(savedDataApi.corpno, requestParam.corp_no)
            }

    }
    @AfterEach
    fun cleanUp() {
        apiRepository.deleteAll()
    }


    //직접입력, 직접출력이라고해요 f(x)=y
    //간접입력, 간접출력이라고하는데 g(f(x))=g(x)
//    fun add(x: Int, y: Int): Int {
//        return x+y
//
//        Stub Spy Dummy Fake / Mock
//    }
}