package com.smatepreview.smatepreview.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseDto(
    @JsonProperty("request_cnt")
    val requestCnt: Int,
    val data: List<Data>) {
}

data class Data(
    val request_param: RequestParam
)

data class RequestParam(
    val b_no: String,
    val p_nm: String,
    val corp_no: String
)
