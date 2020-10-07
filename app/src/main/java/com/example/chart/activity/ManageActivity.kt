package com.example.chart.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chart.R
import com.example.chart.adapter.ManageAdapter
import com.example.chart.utils.ActivityUtils
import kotlinx.android.synthetic.main.activity_notice.*

class ManageActivity : AppCompatActivity() {
    var adapter: ManageAdapter?=null
    var listData = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)
        initView()
    }
    private fun initView() {
        val ms = LinearLayoutManager(this)
        ms.orientation = LinearLayoutManager.VERTICAL
        list.layoutManager = ms
        refresh.setEnableOverScrollDrag(false)
        refresh.setOnRefreshListener { getData() }
        listData.add("123")
        adapter = ManageAdapter(this,R.layout.manage_item,listData)
        list.adapter = adapter
    }

    private fun getData() {

    }
}