package com.example.chart.activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import com.example.chart.R
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.MyNetUtils
import com.example.chart.utils.UserInfo
import com.just.agentweb.AgentWeb
import com.pawegio.kandroid.runDelayed
import com.pawegio.kandroid.startActivity
import kotlinx.android.synthetic.main.activity_company_web1.*
import kotlinx.android.synthetic.main.activity_notice.*

class CompanyWeb1 : BaseActivity() {
    private var agentWeb: AgentWeb? = null

    //企业
    private var url =
        HttpRequestPort.BASE_URL + "appredirect/gotohtml?htmlname=myinfo&type=android&companyid="

    override fun layoutId(): Int = R.layout.activity_company_web1
    var i = 0
    override fun onResume() {
        super.onResume()
        if (i == 0) {
            i = 1
            agentWeb!!.urlLoader.reload()
            runDelayed(2000) {
                i = 0
            }
        }
    }

    override fun initView() {
        bar.layoutParams.height = utils.getStatusBarHeight(this)
        App.instance.addActivity(this)
        UserInfo.companyId
        url += UserInfo.companyId
        agentWeb = AgentWeb.with(this)
            .setAgentWebParent(web_view!!, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator(resources.getColor(R.color.transparent), 0)
            .setWebViewClient(mWebViewClient)
            .setMainFrameErrorView(R.layout.view_no_web, -1)
            .createAgentWeb()
            .go(url)
        agentWeb!!.webCreator.webView.scrollBarSize = 0
        if (Build.VERSION.SDK_INT >= 21) {
            val webSettings = agentWeb!!.agentWebSettings.webSettings
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        if (!MyNetUtils.isNetworkConnected(this)) {
            utils.showToast("请检查是否连接网络,或连接的网络未登录")
        }
        no_web.setOnClickListener {
            agentWeb!!.urlLoader.loadUrl(url)
        }
        bg.setOnClickListener {
            if (show.isVisible) {
                bg.visibility = View.GONE
                show.visibility = View.GONE
            }
        }
        setting.setOnClickListener {
            if (show.isVisible) {
                bg.visibility = View.GONE
                show.visibility = View.GONE
            } else {
                bg.visibility = View.VISIBLE
                show.visibility = View.VISIBLE
            }
        }
        exitPop()
        out.setOnClickListener {
            exitPop!!.showAtLocation(setting, Gravity.NO_GRAVITY, 0, 0)
        }
        changePass.setOnClickListener {
            show.visibility = View.GONE
            bg.visibility = View.GONE
            startActivity<ChangePass>()
        }
    }

    private val mWebViewClient = object : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            runDelayed(1500) {
                if(  no_web.visibility == View.VISIBLE){
                    no_web.visibility = View.GONE
                }
            }
        }

        override fun onReceivedHttpError(
            view: WebView?,
            request: WebResourceRequest?,
            errorResponse: WebResourceResponse?
        ) {
            super.onReceivedHttpError(view, request, errorResponse)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return
            }
            // 在这里显示自定义错误页
            no_web.visibility = View.VISIBLE
            utils.showToast("请检查是否连接网络,或连接的网络未登录")
        }

        @RequiresApi(api = 23)
        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
            val errorCode = error!!.errorCode
            // 断网或者网络连接超时
            if (errorCode == ERROR_HOST_LOOKUP || errorCode == ERROR_TIMEOUT) {
                no_web.visibility = View.VISIBLE
                utils.showToast("请检查是否连接网络,或连接的网络未登录")
            }
            if (request!!.isForMainFrame) {
                no_web.visibility = View.VISIBLE
                utils.showToast("请检查是否连接网络,或连接的网络未登录")
            }
        }

        override fun onPageFinished(view: WebView?, urltwo: String?) {
            super.onPageFinished(view, urltwo)
        }
    }

    //退出弹窗
    var exitPop: PopupWindow? = null

    @SuppressLint("InflateParams")
    private fun exitPop() {
        val view = LayoutInflater.from(this).inflate(R.layout.pop_out, null)
        val sure = view.findViewById<TextView>(R.id.sure)
        val cancel = view.findViewById<TextView>(R.id.cancel)
        exitPop = PopupWindow(
            view, ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT, true
        )
        exitPop!!.isTouchable = true
        exitPop!!.isOutsideTouchable = false
        val dw = ColorDrawable(0x00000000)
        exitPop!!.setBackgroundDrawable(dw)
        sure.setOnClickListener {
            UserInfo.token = ""
            startActivity<LoginActivity>()
            finish()
        }
        cancel.setOnClickListener {
            exitPop!!.dismiss()
        }
    }
}