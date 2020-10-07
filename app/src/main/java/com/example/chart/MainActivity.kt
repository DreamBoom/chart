package com.example.chart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chart.activity.ManageActivity
import com.example.chart.activity.RankingActivity
import com.example.chart.utils.ActivityUtils
import com.pawegio.kandroid.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent()
        intent.setClass(this,RankingActivity::class.java)
        startActivity(intent)
    }
}