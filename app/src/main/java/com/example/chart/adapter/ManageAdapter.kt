package com.example.chart.adapter

import android.app.Activity
import android.content.Intent
import android.widget.RelativeLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.chart.R
import com.example.chart.activity.CompanyWeb
import com.example.chart.bean.CompanyBean


/**
 * @author wmx
 */
class ManageAdapter(private val act: Activity, layoutResId: Int, data: List<CompanyBean.ResultBean.ListBean?>?) :
    BaseQuickAdapter<CompanyBean.ResultBean.ListBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(holder: BaseViewHolder, data: CompanyBean.ResultBean.ListBean) {
        holder.setText(R.id.name, data.companyName)
        val item = holder.getView<RelativeLayout>(R.id.item)
        item.setOnClickListener {
            val intent = Intent()
            intent.setClass(act,CompanyWeb::class.java)
            intent.putExtra("id",data.companyId)
            act.startActivity(intent)
        }
    }
}