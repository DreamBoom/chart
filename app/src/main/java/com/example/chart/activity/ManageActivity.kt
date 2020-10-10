package com.example.chart.activity

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.adapter.AreaAdapter
import com.example.chart.adapter.ManageAdapter
import com.example.chart.bean.AreaBean
import com.example.chart.bean.CompanyBean
import com.example.chart.bean.CompanyNumBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.LogUtils
import com.example.chart.utils.UserInfo
import com.pawegio.kandroid.startActivity
import kotlinx.android.synthetic.main.activity_company_web.*
import kotlinx.android.synthetic.main.activity_manage.*
import kotlinx.android.synthetic.main.activity_manage.bar
import kotlinx.android.synthetic.main.activity_manage.bg
import kotlinx.android.synthetic.main.activity_manage.changePass
import kotlinx.android.synthetic.main.activity_manage.out
import kotlinx.android.synthetic.main.activity_manage.setting
import kotlinx.android.synthetic.main.activity_manage.show


class ManageActivity : BaseActivity() {
    var adapter: ManageAdapter?=null
    var listData = mutableListOf<CompanyBean.ResultBean.ListBean>()
    var chooseArea = ""
    override fun layoutId(): Int =R.layout.activity_manage

    override fun initView() {
        App.instance.addActivity(this)
        areaAdapter = AreaAdapter(this, dataList, R.layout.area_item)
        val ms = LinearLayoutManager(this)
        ms.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = ms
        refresh.setEnableOverScrollDrag(false)
        refresh.setOnRefreshListener { getData() }
        adapter = ManageAdapter(this,R.layout.manage_item,listData)
        list.adapter = adapter
        getArea()
        area.setOnClickListener { showPopup() }
        bg.setOnClickListener {  if (show.isVisible) {
            bg.visibility = View.GONE
            show.visibility = View.GONE
        }  }
        setting.setOnClickListener {
            if (show.isVisible) {
                bg.visibility = View.GONE
                show.visibility = View.GONE
            } else {
                bg.visibility = View.VISIBLE
                show.visibility = View.VISIBLE
            }
        }
        exitPop()
        out.setOnClickListener {
            exitPop!!.showAtLocation(setting, Gravity.NO_GRAVITY, 0, 0)
        }
        changePass.setOnClickListener {
            show.visibility = View.GONE
            startActivity<ChangePass>()
        }
    }

    override fun onResume() {
        super.onResume()
        refresh.autoRefresh()
        getNum()
    }
    private fun getNum() {
        HttpRequestPort.instance.companyNum(chooseArea,object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<CompanyNumBean>() {})
                if(bean.code == 200){
                    num1.text = "${bean.result.companyCount}"
                    num2.text = "${bean.result.completed}"
                    num3.text = "${bean.result.unfinished}"
                }
            }
        })
    }
    private fun getData() {
        HttpRequestPort.instance.company(chooseArea,object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<CompanyBean>() {})
                if(bean.code == 200){
                    listData.clear()
                    listData.addAll(bean.result.list)
                    adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFinished() {
                super.onFinished()
                refresh.finishRefresh()
            }
        })
    }
    private fun getArea() {
        HttpRequestPort.instance.area(object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<AreaBean>() {})
                dataList.addAll(bean.result.list)
                areaAdapter!!.notifyDataSetChanged()
            }

            override fun onError(throwable: Throwable, b: Boolean) {
                super.onError(throwable, b)
                LogUtils.i(throwable.toString())
            }
        })
    }
    var areaAdapter: AreaAdapter? = null
    val dataList = ArrayList<AreaBean.ResultBean.ListBean>()
    var popupWindow: PopupWindow? = null
    private fun showPopup() {
        val v = utils.getView(this, R.layout.pop_area)
        popupWindow = PopupWindow(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        popupWindow!!.contentView = v
        popupWindow!!.setBackgroundDrawable(ColorDrawable(0x00000000))
        popupWindow!!.isClippingEnabled = true
        popupWindow!!.showAsDropDown(name)
        val pop = v.findViewById<RelativeLayout>(R.id.pop)
        val list = v.findViewById<ListView>(R.id.areaList)
        val all = v.findViewById<TextView>(R.id.all)
        list.adapter = areaAdapter
        pop.setOnClickListener { popupWindow!!.dismiss() }
        all.setOnClickListener {
            chooseArea = ""
            getData()
            getNum()
            area.text = "请选择所属区域"
            popupWindow!!.dismiss()
        }
        list.setOnItemClickListener { parent, view, position, id ->
            chooseArea = dataList[position].areaName
            area.text = dataList[position].areaName
            getData()
            getNum()
            popupWindow!!.dismiss()
        }
    }

    //退出弹窗
    var exitPop:PopupWindow?=null
    @SuppressLint("InflateParams")
    private fun exitPop() {
        val view = LayoutInflater.from(this).inflate(R.layout.pop_out, null)
        val sure = view.findViewById<TextView>(R.id.sure)
        val cancel = view.findViewById<TextView>(R.id.cancel)
        exitPop = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT, true)
        exitPop!!.isTouchable = true
        exitPop!!.isOutsideTouchable = false
        val dw = ColorDrawable(0x00000000)
        exitPop!!.setBackgroundDrawable(dw)
        sure.setOnClickListener {
            UserInfo.token = ""
            startActivity<LoginActivity>()
            finish()
        }
        cancel.setOnClickListener {
            exitPop!!.dismiss()
        }
    }
}