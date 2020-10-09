package com.example.chart.net

import java.util.HashMap

/**
 * @author Created by Dream
 * 网络接口
 */
class HttpRequestPort {
    companion object {
        const val BASE_URL = "http://192.168.12.7:8081/hnyfkj-jyindustry/"

        private var httpRequestPort: HttpRequestPort? = null
        val instance: HttpRequestPort
            get() {
                if (httpRequestPort == null) {
                    httpRequestPort = HttpRequestPort()
                }
                return httpRequestPort as HttpRequestPort
            }
    }

    private val login = "webjars/doLogin"
    private val area = "appjars/arealistByPage"
    private val out = "appjars/findMarketList"
    private val inMoney = "appjars/revenueReportList"
    private val money = "appjars/findFinanceList"
    private val kj = "appjars/findAchievementList"
    private val company = "appjars/findCompany"
    private val companyNum = "appjars/companyCount"
    private val pass = "appjars/updatePassword"
    private val notice = "noticelist/selectListCompanyDto"
    private val noticeInfo = "appjars/noticelistfindOne"
    private val httpUtil: HttpUtil = HttpUtil()
    private var map: MutableMap<String, String>? = null

    /**登录*/
    fun login(userName: String,passWord: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["userName"] = userName
        map!!["passWord"] = passWord
        httpUtil.post(BASE_URL + login, map,callBack)
    }
    /**修改密码*/
    fun pass(id:String,oldPwd: String,newPwd: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["id"] = id
        map!!["oldPwd"] = oldPwd
        map!!["newPwd"] = newPwd
        httpUtil.post(BASE_URL + pass, map,callBack)
    }
    /**通知公告*/
    fun notice(companyId:String,page: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["companyId"] = companyId
        map!!["limit"] = "20"
        map!!["page"] = page
        httpUtil.post(BASE_URL + notice, map,callBack)
    }
    /**通知详情*/
    fun noticeInfo(id:String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["id"] = id
        httpUtil.post(BASE_URL + noticeInfo, map,callBack)
    }
    /**区域列表*/
    fun area(callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["page"] = "1"
        map!!["limit"] = "50"
        httpUtil.post(BASE_URL + area, map,callBack)
    }
    /**企业列表*/
    fun company(copanyArea: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["copanyArea"] = copanyArea
        httpUtil.post(BASE_URL + company, map,callBack)
    }
    /**企业统计*/
    fun companyNum(copanyArea: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["copanyArea"] = copanyArea
        map!!["year"] = ""
        httpUtil.post(BASE_URL + companyNum, map,callBack)
    }
    /**企业销售排行*/
    fun out(copanyArea: String,year: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["copanyArea"] = copanyArea
        map!!["year"] = year
        httpUtil.post(BASE_URL + out, map,callBack)
    }

    /**企业税收排行*/
    fun inMoney(copanyArea: String,year: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["copanyArea"] = copanyArea
        map!!["year"] = year
        httpUtil.post(BASE_URL + inMoney, map,callBack)
    }

    /**企业财务营收排行*/
    fun money(copanyArea: String,year: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["copanyArea"] = copanyArea
        map!!["year"] = year
        httpUtil.post(BASE_URL + money, map,callBack)
    }

    /**科技成果排行*/
    fun kj(copanyArea: String,callBack: BaseHttpCallBack) {
        map = HashMap()
        map!!["copanyArea"] = copanyArea
        httpUtil.post(BASE_URL + kj, map,callBack)
    }
}