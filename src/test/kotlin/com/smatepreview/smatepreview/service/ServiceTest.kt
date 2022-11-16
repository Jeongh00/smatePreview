package com.smatepreview.smatepreview.service

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.repository.ApiRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class ServiceTest {

    @Autowired
    lateinit var apiRepository: ApiRepository

    @BeforeEach
    fun presave() {



    }


    @Test
    @DisplayName("Service에 사업자 번호 insert 후 저장")
    fun saveInfo() {

        //GIVEN   where 조건의 값



        //WHEN    테이블에 들어가는 데이터 상태

            given(apiRepository.findAll())
                .willReturn(
                    Api(
                        bno =
                    )
                )

        //THEN    테스트 결과



    }

    @AfterEach
    fun deleteAll() {
        apiRepository.deleteAll()
    }

}