package com.smatepreview.smatepreview.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class StatusResponseDto(
    @JsonProperty("request_cnt")
    val requestCnt: Int,
    val match_cnt: Int,
    val status_code: String,
    val data: List<Detail>) {
}

data class Detail(
    val b_no: String,
    val b_stt: String,
    val b_stt_cd: String,
    val tax_type: String,
    val tax_type_cd: Int,
    val end_dt: String,
    val utcc_yn: String,
    val tax_type_change_dt: String,
    val invoice_apply_dt: String
)
