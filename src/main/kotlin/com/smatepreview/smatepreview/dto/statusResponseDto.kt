package com.smatepreview.smatepreview.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

@JsonIgnoreProperties(ignoreUnknown = true)
data class statusResponseDto(
    @JsonProperty("request_cnt")
    val requestCnt: Int,
    val data: List<Detail>) {
}

data class Detail(
    val b_no: String,
    val b_stt: String,
    val tax_type: String
//    val tax_type_cd: Int,
//    val end_dt: Date
)
