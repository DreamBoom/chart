package com.example.chart.net

import com.alibaba.fastjson.JSON
import org.xutils.common.Callback
import org.xutils.http.RequestParams
import org.xutils.x
import com.example.chart.utils.LogUtils
import com.example.chart.utils.UserInfo
import java.io.File


/**
 * @author Created by Dream
 */
class HttpUtil {
    /**
     * get请求
     * @param url
     * @param map
     * @param callBack
     * @param <T>
     * @return
    </T> */
    operator fun <T> get(url: String, map: Map<String, String>?, callBack: Callback.CommonCallback<T>): Callback.Cancelable {
        val params = RequestParams(url)
        if (map != null) {
            for ((key, value) in map) {
                params.addQueryStringParameter(key, value)
            }
        }
        params.connectTimeout = 5000
        return x.http().get(params, callBack)
    }
    /**
     * post请求
     * @param url
     * @param map
     * @param callback
     * @param <T>
     * @return
    </T> */
    fun <T> postData(url: String, json: String, callback: Callback.CommonCallback<T>): Callback.Cancelable {
        val params = RequestParams(url)
        params.bodyContent = json
        params.addHeader("Content-Type", "application/json")
        params.connectTimeout = 5000
        return x.http().post(params, callback)
    }


    /**
     * post请求
     * @param url
     * @param map
     * @param callback
     * @param <T>
     * @return
    </T> */
    fun <T> post(url: String, map: Map<String, String>?, callback: Callback.CommonCallback<T>): Callback.Cancelable {
        val params = RequestParams(url)
            if(map!=null){
                LogUtils.i(JSON.toJSONString(map))
                params.bodyContent = JSON.toJSONString(map)
            }
        val token = UserInfo.token
        params.addHeader("authToken",token!!)
        params.connectTimeout = 5000
        return x.http().post(params, callback)
    }

    /**
     * 上传文件
     * @param url
     * @param callback
     * @param <T>
     * @return
    </T> */
    fun <T> upload(url: String, file: File, user_id: String, old_img: String, callback: Callback.CommonCallback<T>): Callback.Cancelable {
        val params = RequestParams(url)
        params.isMultipart = true
        params.addBodyParameter("filename", file)
        params.addParameter("version", "v101")
        params.addParameter("user_id", user_id)
        params.addParameter("old_img", old_img)
        params.addHeader("Connection","close")
        params.addQueryStringParameter("fixparam", "android")
        return x.http().post(params, callback)
    }


    fun download(url: String, path: String, callback: Callback.ProgressCallback<File>): Callback.Cancelable {
        val params = RequestParams(url)
        params.saveFilePath = path
        params.isAutoRename = true
        return x.http().post(params, callback)
    }

    fun <T> postJson(url: String, json: String, callBack: BaseHttpCallBack): Callback.Cancelable {
        val params = RequestParams(url)
        params.bodyContent = json
        return x.http().post(params, callBack)
    }
}
