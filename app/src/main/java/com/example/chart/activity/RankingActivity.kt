package com.example.chart.activity

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.adapter.AreaAdapter
import com.example.chart.bean.*
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.LogUtils
import com.example.chart.utils.UserInfo
import com.jzxiang.pickerview.TimePickerDialog
import com.jzxiang.pickerview.data.Type
import com.jzxiang.pickerview.listener.OnDateSetListener
import com.pawegio.kandroid.runDelayed
import com.pawegio.kandroid.startActivity
import kotlinx.android.synthetic.main.activity_ranking.*
import kotlinx.android.synthetic.main.rank_item.*
import kotlinx.android.synthetic.main.rank_item2.*
import kotlinx.android.synthetic.main.rank_item3.*
import kotlinx.android.synthetic.main.rank_item4.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RankingActivity : BaseActivity(), OnDateSetListener {
    override fun layoutId(): Int = R.layout.activity_ranking
    var areaAdapter: AreaAdapter? = null

    @SuppressLint("SimpleDateFormat")
    private var sf = SimpleDateFormat("yyyy-MM")

    @SuppressLint("SimpleDateFormat")
    private var sf1 = SimpleDateFormat("yyyy")
    val dataList = ArrayList<AreaBean.ResultBean.ListBean>()
    var chooseArea = ""
    var chooseTimeType = 0
    private var chooseMonth: TimePickerDialog? = null
    private var chooseYear: TimePickerDialog? = null
    var chooseTime1 = ""
    var chooseTime2 = ""
    var chooseTime3 = ""
    override fun initView() {
        App.instance.addActivity(this)
        areaAdapter = AreaAdapter(this, dataList, R.layout.area_item)
        val curDate = Date(System.currentTimeMillis())
        time1.text = sf.format(curDate)
        chooseTime1 = sf.format(curDate)
        time2.text = sf1.format(curDate)
        chooseTime2 = sf1.format(curDate)
        time3.text = sf.format(curDate)
        chooseTime3 = sf.format(curDate)
        //时间弹窗
        val tenYears = 10L * 365 * 1000 * 60 * 60 * 24L
        chooseMonth = TimePickerDialog.Builder()
            .setCallBack(this)
            .setCancelStringId("取消")
            .setSureStringId("确定")
            .setTitleStringId("选择时间")
            .setYearText("年")
            .setMonthText("月")
            .setDayText("日")
            .setCyclic(false)
            .setMinMillseconds(System.currentTimeMillis() - tenYears)
            .setMaxMillseconds(System.currentTimeMillis() + tenYears)
            .setCurrentMillseconds(System.currentTimeMillis())
            .setThemeColor(ContextCompat.getColor(this, R.color.blue))
            .setType(Type.ALL)
            .setWheelItemTextNormalColor(
                ContextCompat.getColor(
                    this,
                    R.color.timetimepicker_default_text_color
                )
            )
            .setWheelItemTextSelectorColor(ContextCompat.getColor(this, R.color.blue))
            .setWheelItemTextSize(17)
            .setType(Type.YEAR_MONTH)
            .build()
        chooseYear = TimePickerDialog.Builder()
            .setCallBack(this)
            .setCancelStringId("取消")
            .setSureStringId("确定")
            .setTitleStringId("选择时间")
            .setYearText("年")
            .setMonthText("月")
            .setDayText("日")
            .setCyclic(false)
            .setMinMillseconds(System.currentTimeMillis() - tenYears)
            .setMaxMillseconds(System.currentTimeMillis() + tenYears)
            .setCurrentMillseconds(System.currentTimeMillis())
            .setThemeColor(ContextCompat.getColor(this, R.color.blue))
            .setType(Type.ALL)
            .setWheelItemTextNormalColor(
                ContextCompat.getColor(
                    this,
                    R.color.timetimepicker_default_text_color
                )
            )
            .setWheelItemTextSelectorColor(ContextCompat.getColor(this, R.color.blue))
            .setWheelItemTextSize(17)
            .setType(Type.YEAR)
            .build()
        getArea()
        area.setOnClickListener { showPopup() }
        time1.setOnClickListener {
            chooseTimeType = 0
            chooseMonth!!.show(supportFragmentManager, "year_month")
        }
        time2.setOnClickListener {
            chooseTimeType = 1
            chooseYear!!.show(supportFragmentManager, "year_month")
        }
        time3.setOnClickListener {
            chooseTimeType = 2
            chooseMonth!!.show(supportFragmentManager, "year_month")
        }
    }

    override fun onResume() {
        super.onResume()
        getOne()
        getTwo()
        runDelayed(1000) {
            getThree()
            getFour()
        }

    }

    override fun onDateSet(timePickerView: TimePickerDialog?, millseconds: Long) {
        val d = Date(millseconds)
        when (chooseTimeType) {
            0 -> {
                chooseTime1 = sf.format(d)
                time1.text = chooseTime1
                getOne()
            }
            1 -> {
                chooseTime2 = sf1.format(d)
                time2.text = chooseTime2
                getTwo()
            }
            2 -> {
                chooseTime3 = sf.format(d)
                time3.text = chooseTime3
                getThree()
            }
        }


    }

    private fun getArea() {
        HttpRequestPort.instance.area(object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<AreaBean>() {})
                dataList.addAll(bean.result.list)
                areaAdapter!!.notifyDataSetChanged()
            }
        })
    }

    private fun getOne() {
        HttpRequestPort.instance.out(
            chooseArea,
            chooseTime1.trim(),
            object : BaseHttpCallBack(this) {
                override fun success(data: String) {
                    super.success(data)
                    LogUtils.i("111" + chooseTime1 + data)
                    val bean = JSONObject.parseObject(data, object : TypeReference<OutBean>() {})
                    if (bean.code == 200) {
                            when (bean.result.size) {
                                0 -> {
                                    num11.text = "暂无"
                                    num12.text = "暂无"
                                    num13.text = "暂无"
                                    num14.text = "暂无"
                                    num15.text = "暂无"
                                }
                                1 -> {
                                    num11.text = bean.result[0].companyName
                                    num12.text = "暂无"
                                    num13.text = "暂无"
                                    num14.text = "暂无"
                                    num15.text = "暂无"
                                }
                                2 -> {
                                    num11.text = bean.result[0].companyName
                                    num12.text = bean.result[1].companyName
                                    num13.text = "暂无"
                                    num14.text = "暂无"
                                    num15.text = "暂无"
                                }
                                3 -> {
                                    num11.text = bean.result[0].companyName
                                    num12.text = bean.result[1].companyName
                                    num13.text = bean.result[2].companyName
                                    num14.text = "暂无"
                                    num15.text = "暂无"
                                }
                                4 -> {
                                    num11.text = bean.result[0].companyName
                                    num12.text = bean.result[1].companyName
                                    num13.text = bean.result[2].companyName
                                    num14.text = bean.result[3].companyName
                                    num15.text = "暂无"
                                }
                                5 -> {
                                    num11.text = bean.result[0].companyName
                                    num12.text = bean.result[1].companyName
                                    num13.text = bean.result[2].companyName
                                    num14.text = bean.result[3].companyName
                                    num15.text = bean.result[4].companyName
                                }
                        }
                    }
                }
            })
    }

    private fun getTwo() {
        HttpRequestPort.instance.inMoney(
            chooseArea,
            chooseTime2.trim(),
            object : BaseHttpCallBack(this) {
                override fun success(data: String) {
                    super.success(data)
                    LogUtils.i("222" + data)
                    val bean = JSONObject.parseObject(data, object : TypeReference<InMoney>() {})
                    if (bean.status == 0) {
                        when (bean.data.size) {
                            0 -> {
                                num21.text = "暂无"
                                num22.text = "暂无"
                                num23.text = "暂无"
                                num24.text = "暂无"
                                num25.text = "暂无"
                            }
                            1 -> {
                                num21.text = bean.data[0].companyName
                                num22.text = "暂无"
                                num23.text = "暂无"
                                num24.text = "暂无"
                                num25.text = "暂无"
                            }
                            2 -> {
                                num21.text = bean.data[0].companyName
                                num22.text = bean.data[1].companyName
                                num23.text = "暂无"
                                num24.text = "暂无"
                                num25.text = "暂无"
                            }
                            3 -> {
                                num21.text = bean.data[0].companyName
                                num22.text = bean.data[1].companyName
                                num23.text = bean.data[2].companyName
                                num24.text = "暂无"
                                num25.text = "暂无"
                            }
                            4 -> {
                                num21.text = bean.data[0].companyName
                                num22.text = bean.data[1].companyName
                                num23.text = bean.data[2].companyName
                                num24.text = bean.data[3].companyName
                                num25.text = "暂无"
                            }
                            5 -> {
                                num21.text = bean.data[0].companyName
                                num22.text = bean.data[1].companyName
                                num23.text = bean.data[2].companyName
                                num24.text = bean.data[3].companyName
                                num25.text = bean.data[4].companyName
                            }
                        }

                    }
                }
            })
    }

    private fun getThree() {
        HttpRequestPort.instance.money(
            chooseArea,
            chooseTime3.trim(),
            object : BaseHttpCallBack(this) {
                override fun success(data: String) {
                    super.success(data)
                    LogUtils.i("333" + data)
                    val bean = JSONObject.parseObject(data, object : TypeReference<MoneyBean>() {})
                    if (bean.code == 200) {
                        when (bean.result.size) {
                            0 -> {
                                num31.text = "暂无"
                                num32.text = "暂无"
                                num33.text = "暂无"
                                num34.text = "暂无"
                                num35.text = "暂无"
                            }
                            1 -> {
                                num31.text = bean.result[0].companyName
                                num32.text = "暂无"
                                num33.text = "暂无"
                                num34.text = "暂无"
                                num35.text = "暂无"
                            }
                            2 -> {
                                num31.text = bean.result[0].companyName
                                num32.text = bean.result[1].companyName
                                num33.text = "暂无"
                                num34.text = "暂无"
                                num35.text = "暂无"
                            }
                            3 -> {
                                num31.text = bean.result[0].companyName
                                num32.text = bean.result[1].companyName
                                num33.text = bean.result[2].companyName
                                num34.text = "暂无"
                                num35.text = "暂无"
                            }
                            4 -> {
                                num31.text = bean.result[0].companyName
                                num32.text = bean.result[1].companyName
                                num33.text = bean.result[2].companyName
                                num34.text = bean.result[3].companyName
                                num35.text = "暂无"
                            }
                            5 -> {
                                num31.text = bean.result[0].companyName
                                num32.text = bean.result[1].companyName
                                num33.text = bean.result[2].companyName
                                num34.text = bean.result[3].companyName
                                num35.text = bean.result[4].companyName
                            }
                        }
                    }
                }
            })
    }

    private fun getFour() {
        HttpRequestPort.instance.kj(chooseArea, object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                LogUtils.i("444" + data)
                val bean = JSONObject.parseObject(data, object : TypeReference<KjBean>() {})
                if (bean.code == 200) {
                    when (bean.result.size) {
                        0 -> {
                            num41.text = "暂无"
                            num42.text = "暂无"
                            num43.text = "暂无"
                            num44.text = "暂无"
                            num45.text = "暂无"
                        }
                        1 -> {
                            num41.text = bean.result[0].companyName
                            num42.text = "暂无"
                            num43.text = "暂无"
                            num44.text = "暂无"
                            num45.text = "暂无"
                        }
                        2 -> {
                            num41.text = bean.result[0].companyName
                            num42.text = bean.result[1].companyName
                            num43.text = "暂无"
                            num44.text = "暂无"
                            num45.text = "暂无"
                        }
                        3 -> {
                            num41.text = bean.result[0].companyName
                            num42.text = bean.result[2].companyName
                            num43.text = bean.result[3].companyName
                            num44.text = "暂无"
                            num45.text = "暂无"
                        }
                        4 -> {
                            num41.text = bean.result[0].companyName
                            num42.text = bean.result[1].companyName
                            num43.text = bean.result[2].companyName
                            num44.text = bean.result[3].companyName
                            num45.text = "暂无"
                        }
                        5 -> {
                            num41.text = bean.result[0].companyName
                            num42.text = bean.result[1].companyName
                            num43.text = bean.result[2].companyName
                            num44.text = bean.result[3].companyName
                            num45.text = bean.result[4].companyName
                        }
                    }
                }
            }
        })
    }

    var popupWindow: PopupWindow? = null
    private fun showPopup() {
        val v = utils.getView(this, R.layout.pop_area)
        popupWindow = PopupWindow(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        popupWindow!!.contentView = v
        popupWindow!!.setBackgroundDrawable(ColorDrawable(0x00000000))
        popupWindow!!.isClippingEnabled = true
        popupWindow!!.showAsDropDown(area)
        val pop = v.findViewById<RelativeLayout>(R.id.pop)
        val list = v.findViewById<ListView>(R.id.areaList)
        val all = v.findViewById<TextView>(R.id.all)
        list.adapter = areaAdapter
        pop.setOnClickListener { popupWindow!!.dismiss() }
        all.setOnClickListener {
            chooseArea = ""
            getOne()
            getTwo()
            getThree()
            getFour()
            area.text = "请选择所属区域"
            popupWindow!!.dismiss()
        }
        list.setOnItemClickListener { parent, view, position, id ->
            chooseArea = dataList[position].areaName
            area.text = dataList[position].areaName
            getOne()
            getTwo()
            getThree()
            getFour()
            popupWindow!!.dismiss()
        }
    }
}