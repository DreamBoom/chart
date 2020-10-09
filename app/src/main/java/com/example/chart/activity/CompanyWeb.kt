package com.example.chart.activity

import android.graphics.Bitmap
import android.os.Build
import android.view.View
import android.webkit.*
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.example.chart.R
import com.example.chart.net.HttpRequestPort
import com.example.chart.utils.MyNetUtils
import com.just.agentweb.AgentWeb
import com.pawegio.kandroid.runDelayed
import kotlinx.android.synthetic.main.activity_company_web.*

class CompanyWeb : BaseActivity() {
    private var agentWeb: AgentWeb? = null
    //工科委
    private var url = HttpRequestPort.BASE_URL+"appredirect/gotohtml?htmlname=details&type=android&companyid="
    override fun layoutId(): Int = R.layout.activity_company_web
    override fun initView() {
        val id = intent.getStringExtra("id")!!
        com.example.chart.utils.LogUtils.i(id)
        url += id
        agentWeb = AgentWeb.with(this)
            .setAgentWebParent(web_view!!, LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator(resources.getColor(R.color.transparent), 0)
            .setWebViewClient(mWebViewClient)
            .setMainFrameErrorView(R.layout.view_no_web, -1)
            .createAgentWeb()
            .go(url)
        agentWeb!!.webCreator.webView.scrollBarSize = 0
        agentWeb!!.jsInterfaceHolder.addJavaObject("ChangeIcon", ChangeIcon())
        if (Build.VERSION.SDK_INT >= 21) {
            val webSettings = agentWeb!!.agentWebSettings.webSettings
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        if (!MyNetUtils.isNetworkConnected(this)) {
            utils.showToast("请检查是否连接网络,或连接的网络未登录")
        }else{
            agentWeb!!.urlLoader.loadUrl(url)
        }
        no_web.setOnClickListener {
            agentWeb!!.urlLoader.loadUrl(url)
        }
    }

    inner class ChangeIcon {
        @JavascriptInterface
        fun goBack() {
            agentWeb!!.jsAccessEntrace.quickCallJs("getUrl")
        }

        @JavascriptInterface
        fun goClose() {
            finish()
        }
    }

    private val mWebViewClient = object : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            runDelayed(1500) {
                no_web.visibility = View.GONE
            }
            f_view4.visibility = View.VISIBLE
        }

        override fun onReceivedHttpError(view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) {
            super.onReceivedHttpError(view, request, errorResponse)
            f_view4.visibility = View.GONE
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return
            }
            // 在这里显示自定义错误页
            no_web.visibility = View.VISIBLE
            utils.showToast("请检查是否连接网络,或连接的网络未登录")
        }

        @RequiresApi(api = 23)
        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
            super.onReceivedError(view, request, error)
            f_view4.visibility = View.GONE
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
            f_view4.visibility = View.GONE
        }
    }
}