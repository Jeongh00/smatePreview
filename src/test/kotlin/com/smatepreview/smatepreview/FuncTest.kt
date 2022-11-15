package com.smatepreview.smatepreview

import org.junit.jupiter.api.Test

class FuncTest {

    private val context: Empty? = null

    @Test
    fun sut_inquiry_business_registration_service_by_rest_template_test() {
        first("params") {
            "first"
        }

        second("params") {
            "secord"
        }

        third("params") {
            return@third "return third"
        }

        four("params") {
            "four"
        }

        println(Empty().five(Empty::toString))
    }

    fun <T> a(x: T) {
        T
        println(x)
    }

    inline fun first(test: String, function: (Empty) -> String) {
        val invoke = function.invoke(context)
        println("frist : $invoke")
    }

    inline fun second(test: String, noinline function: (Empty) -> String) {
        val invoke = function.invoke(context)
        println("second : $invoke")
    }

    inline fun <T: String> third(test: String, crossinline function: (Empty) -> T) {
        val invoke: T = function.invoke(context)
        println("third : $invoke")
        T::class.java
    }

    inline fun <reified T: String> four(test: String, crossinline function: (Empty) -> T) {
        val invoke: T = function.invoke(context)
        println(if(T::class.java == String::class.java) "True $invoke" else "False $invoke")
        T::class.java
    }

    fun <T: Empty> T.five(function: T.() -> String): String {
        return function(this)
    }

    class Empty
}