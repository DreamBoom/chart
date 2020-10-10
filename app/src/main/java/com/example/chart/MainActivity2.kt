package com.example.chart

import android.app.TabActivity
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import com.example.chart.activity.App
import com.example.chart.activity.CompanyWeb
import com.example.chart.activity.CompanyWeb1
import com.example.chart.activity.NoticeActivity
import com.example.chart.utils.ActivityUtils
import com.example.chart.utils.Tool
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.buttom_bar2.*
import kotlin.system.exitProcess

class MainActivity2 : TabActivity() {
    private var firstTime: Long = 0
    private var utils = ActivityUtils(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initView()
    }
    private fun initView() {
        val tab1 = tabhost
        tab1!!.addTab(
            tab1.newTabSpec("one").setIndicator("统计分析")
                .setContent(Intent(this, CompanyWeb1::class.java))
        )
        tab1.addTab(
            tab1.newTabSpec("two").setIndicator("通知公告")
                .setContent(Intent(this, NoticeActivity::class.java))
        )
        tab1.setOnTabChangedListener { s ->
            setIconBackGround()
            when (s) {
                Tool.one -> {
                    im_one!!.setBackgroundResource(R.mipmap.bottom_icon_tjfx)
                    tv_one!!.setTextColor(resources.getColor(R.color.blue))
                }
                Tool.two -> {
                    im_two!!.setBackgroundResource(R.mipmap.bottom_icon_tzgg)
                    tv_two!!.setTextColor(resources.getColor(R.color.blue))
                }
            }
        }

        rb_home.setOnClickListener {
            tabhost!!.setCurrentTabByTag("one")
        }
        rb_service.setOnClickListener {
            tabhost!!.setCurrentTabByTag("two")
        }
    }

    private fun setIconBackGround() {
        im_one!!.setBackgroundResource(R.mipmap.bottom_icon_tjgx1)
        tv_one!!.setTextColor(resources.getColor(R.color.text_gray))
        im_two!!.setBackgroundResource(R.mipmap.bottom_icon_tzgg1)
        tv_two!!.setTextColor(resources.getColor(R.color.text_gray))
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_BACK) {
            val secondTime = System.currentTimeMillis()
            if (secondTime - firstTime > 2000) {
                utils.showToast("再按一次退出程序")
                firstTime = secondTime
                return false
            } else {
                App.instance.removeAllActivity()
                exitProcess(0)
            }
        }
        return super.dispatchKeyEvent(event)
    }
}