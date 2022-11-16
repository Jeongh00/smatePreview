package com.smatepreview.smatepreview.repository

import com.smatepreview.smatepreview.domain.Api
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RepositoryTest {

    @Autowired
    lateinit var apiRepository: ApiRepository

    @BeforeEach
    fun init() {
        val businessNumber: String = "TEST-NUMBER"
        val companyName: String = "TEST-NAME"
        apiRepository.save(
            Api(
                null,
                businessNumber,
                companyName,
                "",
                "",
                "",
                "",
                "",
                ""
            )
        )
    }

    @Test
    @DisplayName("사업자 등록 번호를 통해 사업저 정보 조회 in DB")
    fun findByBusinessNumberTest() {
        // given
        val businessNumber: String = "TEST-NUMBER"
        val companyName: String = "TEST-NAME"
        // when

        // then
        val saupEntity = apiRepository.findAll(businessNumber)
        assertNotNull(saupEntity)
        assertEquals(saupEntity.businessNumber, businessNumber)
        assertEquals(saupEntity.companyName, companyName)

    }

    @AfterEach
    fun cleanUp() {
        apiRepository.deleteAll()
    }
















}