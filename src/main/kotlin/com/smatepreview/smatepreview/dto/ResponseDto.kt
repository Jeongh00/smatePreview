package com.smatepreview.smatepreview.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.json.JSONPropertyIgnore

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseDto(
    @JsonProperty("request_cnt")
    val requestCnt: Int
) {
}