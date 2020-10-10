package com.example.chart.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.adapter.NoticeAdapter
import com.example.chart.bean.NoticListBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.LogUtils
import com.example.chart.utils.UserInfo
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.activity_company_web.*
import kotlinx.android.synthetic.main.activity_notice.*


class NoticeActivity : BaseActivity() {
    var adapter: NoticeAdapter? = null
    var listData = mutableListOf<NoticListBean.ResultBean.ListBean>()
    override fun layoutId(): Int = R.layout.activity_notice
    var page = 1
    override fun initView() {
        ImmersionBar.with(this)
            .statusBarColor(R.color.transparent) //状态栏颜色，不写默认透明色
            .statusBarDarkFont(true) //状态栏字体是深色，不写默认为亮色
            .fitsSystemWindows(true) //解决状态栏和布局重叠问题，任选其一，默认为false，当为true时一定要指定statusBarColor()，不然状态栏为透明色，还有一些重载方法
            .init() //必须调用方可应用以上所配置的参数

        App.instance.addActivity(this)
        val ms = LinearLayoutManager(this)
        ms.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = ms
        refresh.setEnableOverScrollDrag(false)
        refresh.setOnRefreshListener {
            page = 1
            getData()
        }
        refresh.setOnLoadMoreListener { getData() }
        adapter = NoticeAdapter(this, R.layout.notice_item, listData)
        list.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        refresh.autoRefresh()
    }

    private fun getData() {
        LogUtils.i(page)
        val companyId = UserInfo.companyId
        HttpRequestPort.instance.notice(companyId!!, "$page", object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<NoticListBean>() {})
                if (bean.code == 200) {
                    if (bean.result.list.size > 0) {
                        noData.visibility = View.GONE
                        if (page == 1) {
                            listData.clear()
                        }
                        page++
                        listData.addAll(bean.result.list)
                    } else {
                        if (page == 1) {
                            noData.visibility = View.VISIBLE
                        }
                    }
                } else {
                    utils.showToast(bean.msg)
                }
            }

            override fun onError(throwable: Throwable, b: Boolean) {
                super.onError(throwable, b)
                LogUtils.i(throwable.toString())
                utils.showToast("网络请求失败，请稍后重试")
                noData.visibility = View.VISIBLE
            }

            override fun onFinished() {
                super.onFinished()
                refresh.finishRefresh()
                refresh.finishLoadMore()
            }
        })
    }
}