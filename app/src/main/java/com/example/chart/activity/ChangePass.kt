package com.example.chart.activity
import android.text.TextUtils
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.bean.ChangePassBean
import com.example.chart.bean.CompanyNumBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.LogUtils
import com.example.chart.utils.UserInfo
import kotlinx.android.synthetic.main.activity_change_pass.*
import kotlinx.android.synthetic.main.activity_manage.*

class ChangePass : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_change_pass
    override fun initView() {
        App.instance.addActivity(this)
        change.setOnClickListener {
            val old = oldPass.text.toString()
            val new = newPass.text.toString()
            val newPass = newPass1.text.toString()
            if(TextUtils.isEmpty(old)){
                utils.showToast("请输入原密码")
                return@setOnClickListener
            }
            val pass = UserInfo.pass
            if(old!=pass){
                utils.showToast("原密码错误,请重新输入")
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(new)){
                utils.showToast("请输入原密码")
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(newPass)){
                utils.showToast("请输入原密码")
                return@setOnClickListener
            }
            if(new!=newPass){
                utils.showToast("密码不一致,请重新输入")
                return@setOnClickListener
            }
            changePass(old,newPass)
        }
    }

    private fun changePass(old:String,newPass:String) {
        val id = UserInfo.id
        HttpRequestPort.instance.pass("$id",old,newPass,object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                LogUtils.i(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<ChangePassBean>() {})
                if(bean.code == 200){
                    utils.showToast("修改成功")
                    finish()
                }else{
                    utils.showToast(bean.msg)
                }
            }

            override fun onError(throwable: Throwable, b: Boolean) {
                super.onError(throwable, b)
                utils.showToast("网络请求失败，请稍后重试")
            }
        })
    }
}