package com.example.chart.adapter

import android.app.Activity
import android.content.Intent
import android.widget.RelativeLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.chart.R
import com.example.chart.activity.NoticeInfoActivity
import com.example.chart.bean.NoticListBean


/**
 * @author wmx
 */
class NoticeAdapter(private val act: Activity, layoutResId: Int, data: List<NoticListBean.ResultBean.ListBean?>?) :
    BaseQuickAdapter<NoticListBean.ResultBean.ListBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, data: NoticListBean.ResultBean.ListBean) {
        holder.setText(R.id.name, data.noticeTitle)
        holder.setText(R.id.time, data.insertTime)
        holder.getView<RelativeLayout>(R.id.item).setOnClickListener {
            val intent = Intent()
            intent.setClass(act,NoticeInfoActivity::class.java)
            intent.putExtra("id","${data.id}")
            act.startActivity(intent)
        }
    }
}