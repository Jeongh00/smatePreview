package com.smatepreview.smatepreview.repository

import com.smatepreview.smatepreview.domain.Api
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Repository

@Repository
interface ApiRepository : JpaRepository<Api, Long> {

}