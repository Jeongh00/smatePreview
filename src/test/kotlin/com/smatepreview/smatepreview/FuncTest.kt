//package com.smatepreview.smatepreview
//
//import org.junit.jupiter.api.Test
//import org.springframework.context.support.GenericApplicationContext
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context
//
//
//class FuncTest {
//
//    @Test
//    fun sut_inquiry_business_registration_service_by_rest_template_test() {
//        first("params") {
//            "first"
//        }
//
//        second("params") {
//            "secord"
//        }
//
//        third("params") {
//            return@third "return third"
//        }
//
//        four("params") {
//            "four"
//        }
//
//        println(GenericApplicationContext().five(GenericApplicationContext::toString))
//    }
//
//    inline fun first(test: String, function: (GenericApplicationContext) -> String) {
//        val invoke = function.invoke(context)
//        println("frist : $invoke")
//    }
//
//    inline fun second(test: String, noinline function: (GenericApplicationContext) -> String) {
//        val invoke = function.invoke(context)
//        println("second : $invoke")
//    }
//
//    inline fun <T: String> third(test: String, crossinline function: (GenericApplicationContext) -> T) {
//        val invoke: T = function.invoke(context)
//        println("third : $invoke")
//    }
//
//    inline fun <reified T: String> four(test: String, crossinline function: (GenericApplicationContext) -> T) {
//        val invoke: T = function.invoke(context)
//        println(if(T::class.java == String::class.java) "True $invoke" else "False $invoke")
//    }
//
//    fun <T: GenericApplicationContext> T.five(function: T.() -> String): String {
//        return function(this)
//    }
//
//}