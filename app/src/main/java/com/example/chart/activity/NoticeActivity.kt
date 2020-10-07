package com.example.chart.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chart.R
import com.example.chart.adapter.NoticeAdapter
import kotlinx.android.synthetic.main.activity_notice.*

class NoticeActivity : AppCompatActivity() {
    var adapter:NoticeAdapter?=null
    var listData = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)
        initView()
    }
     private fun initView() {
        val ms = LinearLayoutManager(this)
        ms.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = ms
        refresh.setEnableOverScrollDrag(false)
        refresh.setOnRefreshListener { getData() }
        adapter = NoticeAdapter(this,R.layout.notice_item,listData)
        list.adapter = adapter
    }

    private fun getData() {

    }
}