package com.example.chart.utils

import com.chibatching.kotpref.KotprefModel


/**
 * @author Created by Dream
 */
object Tool {
    //sp的文件名
    val RESULTCODE_SUCCESS = 200
    val RESULTCODE_setting = 101
    val RESULTCODE_device = 102

    val one = "one"
    val two = "two"
}
object UserInfo : KotprefModel() {
    var id by intPref(default = 0)
    var pass by nullableStringPref("")
    var companyId by nullableStringPref("")
    var userName by nullableStringPref("")
    var companyName by nullableStringPref("")
    var token by nullableStringPref("")
    var roleType by intPref(default = 0)
//    var highScore by longPref()
//    var rate by floatPref()
}

enum class GameLevel {
    EASY,
    NORMAL,
    HARD
}