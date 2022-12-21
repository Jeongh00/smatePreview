package com.smatepreview.smatepreview.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.smatepreview.smatepreview.ParameterBuilder
import org.springframework.util.StringUtils

class testingDTO {

    data class Request(
        @JsonProperty("SCH_TYP_CD")
        val schTypCd: String,
        @JsonProperty("SCH_KEYWORD")
        val schKeyword: String
    ) {
        fun toParameter(): String = when {
            !StringUtils.hasText(schTypCd) -> throw IllegalArgumentException("schTypeCd is not empty")
            !StringUtils.hasText(schKeyword) -> throw IllegalArgumentException("schKeyword is not empty")
            else -> {
                val sb = ParameterBuilder.ParameterBuilder()

                sb += "schTypeCd=$schTypCd&"
                sb += "schKeyword=$schKeyword"

                sb.toParameter()
            }
        }
    }

    data class Response(
        @JsonProperty("MBR_ID")
        val mbrId: String,
        @JsonProperty("JOIN_ST_CD")
        val joinStCd: String
    )

}