package com.example.chart.adapter

import android.app.Activity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.chart.R


/**
 * @author wmx
 */
class NoticeAdapter(private val act: Activity, layoutResId: Int, data: List<String?>?) :
    BaseQuickAdapter<String, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, data: String) {
        holder.setText(R.id.name, data)

    }
}