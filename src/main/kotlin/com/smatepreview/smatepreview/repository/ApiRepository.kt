package com.smatepreview.smatepreview.repository

import com.smatepreview.smatepreview.domain.Api
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ApiRepository : CrudRepository<Api, Long>