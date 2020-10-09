package com.example.chart.activity

import android.text.TextUtils
import android.widget.Toast
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.bean.NoticeInfoBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.zzhoujay.richtext.RichText
import com.zzhoujay.richtext.callback.OnUrlClickListener
import kotlinx.android.synthetic.main.activity_notice_info.*

class NoticeInfoActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_notice_info
    override fun initView() {
        val id = intent.getStringExtra("id")
        getInfo(id!!)
    }

    private fun getInfo(id: String) {
        HttpRequestPort.instance.noticeInfo(id, object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<NoticeInfoBean>() {})
                if (bean.code == 200) {
                    if (!TextUtils.isEmpty(bean.result.noticeContent)) {
                        RichText.initCacheDir(this@NoticeInfoActivity)
                        RichText.debugMode = true
                        RichText.from(bean.result.noticeContent)
                            .urlClick(OnUrlClickListener { url ->
                                if (url.startsWith("code://")) {
                                    Toast.makeText(
                                        this@NoticeInfoActivity,
                                        url.replaceFirst("code://".toRegex(), ""),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@OnUrlClickListener true
                                }
                                false
                            })
                            .into(info)
                    }
                }
            }
        })
    }
}