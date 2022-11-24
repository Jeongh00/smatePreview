package com.smatepreview.smatepreview.repository

import com.querydsl.jpa.impl.JPAInsertClause
import com.smatepreview.smatepreview.domain.Stauts
import com.smatepreview.smatepreview.dto.Detail
import com.smatepreview.smatepreview.dto.StatusRequestDto

interface QStautsRepository {

    fun saveStatus(detail: Detail): Long?

}