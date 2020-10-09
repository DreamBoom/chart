package com.example.chart.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.adapter.NoticeAdapter
import com.example.chart.bean.CompanyNumBean
import com.example.chart.bean.NoticListBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.LogUtils
import com.example.chart.utils.UserInfo
import kotlinx.android.synthetic.main.activity_manage.*
import kotlinx.android.synthetic.main.activity_notice.*
import kotlinx.android.synthetic.main.activity_notice.list
import kotlinx.android.synthetic.main.activity_notice.refresh

class NoticeActivity : BaseActivity() {
    var adapter: NoticeAdapter? = null
    var listData = mutableListOf<NoticListBean.ResultBean.ListBean>()
    override fun layoutId(): Int = R.layout.activity_notice
    var page = 1
    override fun initView() {
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
        refresh.autoRefresh()
    }

    private fun getData() {
        val companyId = UserInfo.companyId
        HttpRequestPort.instance.notice(companyId!!, "$page", object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<NoticListBean>() {})
                if (bean.code == 200) {
                    if (bean.result.list.size > 0) {
                        noData.visibility = View.GONE
                        if(page == 1){
                            listData.clear()
                        }
                        page++
                        listData.addAll(bean.result.list)
                    } else {
                        if (page == 1) {
                            noData.visibility = View.VISIBLE
                        }
                    }
                }else{
                    utils.showToast(bean.msg)
                }
            }

            override fun onError(throwable: Throwable, b: Boolean) {
                super.onError(throwable, b)
                utils.showToast("网络请求失败，请稍后重试")
                noData.visibility = View.VISIBLE
            }

            override fun onFinished() {
                super.onFinished()
                refresh.finishRefresh()
            }
        })
    }
}