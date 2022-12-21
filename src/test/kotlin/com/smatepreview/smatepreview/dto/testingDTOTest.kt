package com.smatepreview.smatepreview.dto

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class testingDTOTest {

    companion object Check {

        lateinit var objectMapper: ObjectMapper

        @BeforeAll
        @JvmStatic
        fun init() {
            objectMapper = ObjectMapper()
                .registerModule(JavaTimeModule())
                .registerModule(KotlinModule.Builder().build())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        }
    }

    @Test
    @DisplayName("Reqeust test")
    fun request_test() {

        // given
        val request = testingDTO.Request(
            "schTypeCd",
            "schKeyword"
        )

        // when
        val parameter = request.toParameter()

        // then
        Assertions.assertEquals("schTypeCd=schTypeCd&schKeyword=schKeyword", parameter)
    }

    @Test
    @DisplayName("Response test - 직렬화 테스트")
    fun response_test_serialize() {

        // given
        val response = testingDTODummy.getResponse()

        // when
        val writeValueAsString = objectMapper.writeValueAsString(response)

        // then
        Assertions.assertTrue(writeValueAsString.contains(""))
    }

    @Test
    @DisplayName("Response test - 역직렬화 테스트")
    fun response_test_deserialize() {

        // given
        val response = testingDTODummy.getResponse()

        // when
        val data = objectMapper.readValue(response, testingDTO.Response::class.java)

        // then
        Assertions.assertEquals("mbrId", data.mbrId)
    }
    
}