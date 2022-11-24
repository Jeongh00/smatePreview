package com.smatepreview.smatepreview.repository

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.domain.QStauts
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ApiRepository : JpaRepository<Api, Long>, QApiRepository, QStautsRepository, QStautsFindRepository {

//    @Modifying
//    @Query("update Api a set a.bno = :bno , a.corpno = :corpno , a.pnm = :pnm where a.id = :id")
//    fun update(@Param(value = "id") apiId: Long, @Param(value = "bno") bno: String?, @Param(value = "corpno") corpno: String?, @Param(value = "pnm") pnm: String?)

}