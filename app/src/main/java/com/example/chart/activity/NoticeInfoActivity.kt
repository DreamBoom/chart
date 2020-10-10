package com.example.chart.activity

import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.bean.NoticeInfoBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.StatusBarUtil
import com.zzhoujay.richtext.RichText
import com.zzhoujay.richtext.callback.OnUrlClickListener
import kotlinx.android.synthetic.main.activity_notice_info.*


class NoticeInfoActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_notice_info
    var url = ""
    override fun initView() {
        App.instance.addActivity(this)
        utils.changeStatusBlack(true,window)
        val id = intent.getStringExtra("id")
        getInfo(id!!)
        fj.setOnClickListener {
            if(!TextUtils.isEmpty(url)){
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                val contentUrl: Uri = Uri.parse(url)
                intent.data = contentUrl
                startActivity(Intent.createChooser(intent, "请选择浏览器"))
            }
        }
        back.setOnClickListener { finish() }
    }

    private fun getInfo(id: String) {
        HttpRequestPort.instance.noticeInfo(id, object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                com.example.chart.utils.LogUtils.i(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<NoticeInfoBean>() {})
                if (bean.code == 200) {
                    if (!TextUtils.isEmpty(bean.result.noticeContent)) {
                        name.text = bean.result.noticeTitle
                        user.text = bean.result.userName
                        time.text = bean.result.insertTime
                        url = "http://115.56.231.22:8083/"+bean.result.noticeUrl
                        val split = bean.result.noticeUrl.split("/")
                        val split1 = split[split.size - 1].split("_")
                        fj.text = split1[split1.size - 1]
                        RichText.initCacheDir(this@NoticeInfoActivity)
                        RichText.debugMode = true
                        RichText.from(bean.result.noticeContent)
                            .urlClick(OnUrlClickListener { url ->
                                val intent = Intent()
                                intent.action = Intent.ACTION_VIEW
                                val contentUrl: Uri = Uri.parse(url)
                                intent.data = contentUrl
                                startActivity(Intent.createChooser(intent, "请选择浏览器"))
                                false
                            })
                            .into(info)
                    }
                }
            }
        })
    }
}