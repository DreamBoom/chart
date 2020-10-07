package com.example.chart.net

/**
 * @author Created by Dream
 * 网络接口
 */
class HttpRequestPort {
    companion object {
        const val BASE_URL = "http://nywlw.hnyfkj.com/"

        private var httpRequestPort: HttpRequestPort? = null
        val instance: HttpRequestPort
            get() {
                if (httpRequestPort == null) {
                    httpRequestPort = HttpRequestPort()
                }
                return httpRequestPort as HttpRequestPort
            }
    }

    private val data = "api/v2/weatherStation/uploadWeatherData"
    private val httpUtil: HttpUtil = HttpUtil()
    private var map: MutableMap<String, String>? = null

    /**上传环境数据*/
    fun data(json: String,callBack: BaseHttpCallBack) {
        httpUtil.postData(BASE_URL + data, json,callBack)
    }

}