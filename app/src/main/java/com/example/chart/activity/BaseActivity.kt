package com.example.chart.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.chart.utils.ActivityUtils

abstract class BaseActivity : AppCompatActivity() {
    val utils = ActivityUtils(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()

    }

    abstract fun layoutId(): Int
    abstract fun initView()

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            // 判断连续点击事件时间差
            if (utils.isFastClick()) {
                return true
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}