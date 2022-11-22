package com.smatepreview.smatepreview.repository

import com.smatepreview.smatepreview.domain.Api
import com.smatepreview.smatepreview.domain.Stauts
import com.smatepreview.smatepreview.dto.SearchCondition

interface QApiRepository {
    fun search(search: SearchCondition): Api?

    fun saveStatus(stauts: Stauts): Stauts?
}