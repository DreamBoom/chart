package com.example.chart.activity
import android.text.TextUtils
import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.TypeReference
import com.example.chart.R
import com.example.chart.bean.ChangePassBean
import com.example.chart.bean.CompanyNumBean
import com.example.chart.net.BaseHttpCallBack
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.InFilter
import com.example.chart.utils.LogUtils
import com.example.chart.utils.UserInfo
import com.gyf.immersionbar.ImmersionBar
import com.pawegio.kandroid.startActivity
import kotlinx.android.synthetic.main.activity_change_pass.*

class ChangePass : BaseActivity() {
    override fun layoutId(): Int = R.layout.activity_change_pass

    override fun initView() {
        App.instance.addActivity(this)
        bg.setOnClickListener { utils.hideSoftKeyboard() }
        ImmersionBar.with(this)
            .statusBarColor(R.color.transparent) //状态栏颜色，不写默认透明色
            .statusBarDarkFont(true) //状态栏字体是深色，不写默认为亮色
            .fitsSystemWindows(true) //解决状态栏和布局重叠问题，任选其一，默认为false，当为true时一定要指定statusBarColor()，不然状态栏为透明色，还有一些重载方法
            .init() //必须调用方可应用以上所配置的参数
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
                utils.showToast("请输入新密码")
                return@setOnClickListener
            }
            if(new.length<6){
                utils.showToast("新密码长度不得低于6位")
                return@setOnClickListener
            }
            if(new.length>16){
                utils.showToast("新密码长度最高16位")
                return@setOnClickListener
            }
            if(!InFilter.pass(new)){
                utils.showToast("新密码必须是数字和字母组合")
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(newPass)){
                utils.showToast("请确认新密码")
                return@setOnClickListener
            }
            if(new!=newPass){
                utils.showToast("密码不一致,请重新输入")
                return@setOnClickListener
            }
            changePass(old,newPass)
        }
        back.setOnClickListener { finish() }
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
                    UserInfo.token = ""
                    startActivity<LoginActivity>()
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