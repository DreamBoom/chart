package com.example.chart.activity

import android.text.TextUtils
import android.view.KeyEvent
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.MainActivity
import com.example.chart.MainActivity2
import com.example.chart.R
import com.example.chart.bean.LoginBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.LogUtils
import com.example.chart.utils.UserInfo
import com.pawegio.kandroid.startActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.system.exitProcess

class LoginActivity : BaseActivity() {
    private var firstTime: Long = 0
    override fun layoutId(): Int = R.layout.activity_login
    override fun initView() {
        App.instance.addActivity(this)
        sure.setOnClickListener {
            val name = name.text.toString()
            val pass = pass.text.toString()
            login(name, pass)
        }
        val token = UserInfo.token
        if(!TextUtils.isEmpty(token)){
            if(UserInfo.roleType==2){
                startActivity<MainActivity>()
            }else{
                startActivity<MainActivity2>()
            }
        }
    }

    private fun login(name: String, pass: String) {
        HttpRequestPort.instance.login(name, pass, object : BaseHttpCallBack(this) {
            override fun success(data: String) {
                super.success(data)
                LogUtils.i(data)
                val bean = JSONObject.parseObject(data, object : TypeReference<LoginBean>() {})
                if (bean.code == 200) {
                    UserInfo.pass = pass
                    UserInfo.id = bean.result.id
                    UserInfo.roleType = bean.result.roleType
                    UserInfo.token = bean.result.token
                    UserInfo.id = bean.result.id
                    if (!TextUtils.isEmpty(bean.result.companyId)) {
                        UserInfo.companyId = bean.result.companyId
                    }
                    if (!TextUtils.isEmpty(bean.result.companyName)) {
                        UserInfo.companyName = bean.result.companyName
                    }
                    //2 工科委 3 企业用户
                    when (bean.result.roleType) {
                        2 -> { startActivity<MainActivity>() }
                        3 -> { startActivity<MainActivity2>() }
                        else -> { utils.showToast("请登录正确用户") }
                    }
                }else{
                    utils.showToast(bean.msg)
                }
            }

            override fun onError(throwable: Throwable, b: Boolean) {
                super.onError(throwable, b)
                utils.showToast("登录失败,请检查网络或重新登录")
            }

            override fun onFinished() {
                super.onFinished()
                utils.hindProgress()

            }
        })
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