package com.example.chart.activity

import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.adapter.FjAdapter
import com.example.chart.bean.FjBean
import com.example.chart.bean.NoticeInfoBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.gyf.immersionbar.ImmersionBar
import com.zzhoujay.richtext.RichText
import com.zzhoujay.richtext.callback.OnUrlClickListener
import kotlinx.android.synthetic.main.activity_notice_info.*


class NoticeInfoActivity : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_notice_info
    var FjList = arrayListOf<FjBean>()
    var gridAdapter: FjAdapter? = null
    override fun initView() {
        ImmersionBar.with(this)
            .statusBarColor(R.color.transparent) //状态栏颜色，不写默认透明色
            .statusBarDarkFont(true) //状态栏字体是深色，不写默认为亮色
            .fitsSystemWindows(true) //解决状态栏和布局重叠问题，任选其一，默认为false，当为true时一定要指定statusBarColor()，不然状态栏为透明色，还有一些重载方法
            .init() //必须调用方可应用以上所配置的参数
        App.instance.addActivity(this)
        utils.changeStatusBlack(true, window)
        val id = intent.getStringExtra("id")
        getInfo(id!!)
        gridAdapter = FjAdapter(this@NoticeInfoActivity, FjList, R.layout.fj_item)
        grid.adapter = gridAdapter
        back.setOnClickListener { finish() }

    }

    private fun getInfo(id: String) {
        HttpRequestPort.instance.noticeInfo(id, object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<NoticeInfoBean>() {})
                if (bean.code == 200) {
                    if (!TextUtils.isEmpty(bean.result.noticeContent)) {
                        name.text = bean.result.noticeTitle
                        user.text = bean.result.userName
                        time.text = bean.result.insertTime
                        if(!TextUtils.isEmpty(bean.result.noticeUrl)){
                            val strList = bean.result.noticeUrl.split(",")
                            for (i in strList.indices) {
                                val split = strList[i].split("_")
                                val fjBean = FjBean()
                                fjBean.name = split[split.size - 1]
                                fjBean.url = "http://115.56.231.22:8083/${strList[i]}"
                                FjList.add(fjBean)
                            }
                            gridAdapter!!.notifyDataSetChanged()
                        }
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