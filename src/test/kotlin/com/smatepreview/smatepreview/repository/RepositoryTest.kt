package com.smatepreview.smatepreview.repository

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.dto.RequestParam
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class RepositoryTest {

    @Autowired
    lateinit var apiRepository: ApiRepository

    @BeforeEach
    fun presave() {


    }

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

    @Test
    @DisplayName("data들 db에서 조회 잘 되는지 확인")
    fun assertFindData() {

        // given
            val (id, bno, pnm, corpno) = apiRepository.save(
                Api(
                    "2118677762",
                    "손석민",
                    "1101112250598"
                )
            )

        // when
            id?.also {
                var findDataList: Optional<Api> = apiRepository.findById(id)
                var dataList: Api = findDataList.get()


                // then

                assertEquals(dataList.bno, bno)
                assertEquals(dataList.pnm, pnm)
                assertEquals(dataList.corpno, corpno)

            }


    }

    @Test
    @DisplayName("data들 db에서 수정 잘 되는지 확인")
    fun assertEditData() {

        // given

            val (id, _, _, _) = apiRepository.save(
                Api(
                    "2118677762",
                    "손석민",
                    "1101112250598"
                )
            )

            val requestParam2 = RequestParam(
                "2118672",
                "손석민123",
                "110110598"
            )

        // when

        id?.also{

            val api = this.apiRepository.findById(id).get()
            api.pnm = requestParam2.p_nm
            api.bno = requestParam2.b_no
            api.corpno = requestParam2.corp_no

            // then

                assertNotNull(id)

                assertEquals(api.bno, requestParam2.b_no)
                assertEquals(api.pnm, requestParam2.p_nm)
                assertEquals(api.corpno, requestParam2.corp_no)

        }

    }

    @AfterEach
    fun cleanUp() {
        apiRepository.deleteAll()
    }


}