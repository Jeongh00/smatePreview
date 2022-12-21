package com.smatepreview.smatepreview

class ParameterBuilder {

    data class ParameterBuilder(private val stringBuilder: StringBuilder = StringBuilder()) {

        operator fun plusAssign(value: String) {
            this.stringBuilder.append(value)
        }

        fun toParameter(): String {
            return this.stringBuilder.toString().removeSuffix("&")
        }
    }

}