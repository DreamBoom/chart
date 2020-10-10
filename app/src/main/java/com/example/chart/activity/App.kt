package com.example.chart.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import com.chibatching.kotpref.Kotpref
import org.xutils.x
import com.example.chart.utils.MyCatchException
import java.util.*


class App : Application() {
    private var activists: MutableList<Activity>? = null
    var activitys: MutableList<Activity>?
        get() = activists
        set(activitys) {
            this.activists = activitys
        }

    init {
        activists = LinkedList()
    }
    /**添加Activity到容器中 */
    fun addActivity(activity: Activity) {
        if (activists != null && activists!!.size > 0) {
            if (!activists!!.contains(activity)) {
                activists!!.add(activity)
            }
        } else {
            activists!!.add(activity)
        }
    }

    /** 遍历所有Activity并finish */
    fun removeAllActivity() {
        if (activists != null && activists!!.size > 0) {
            for (activity in activists!!) {
                activity.finish()
            }
        }
    }
    override fun onCreate() {
        super.onCreate()
        x.Ext.init(this)
        Kotpref.init(this)
        context = applicationContext
        //异常捕获
        val mException = MyCatchException.getInstance()
        mException.init(applicationContext) //注册

    }


    companion object {
        private var myApplication: App? = null
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
            private set
        //最近定位时间

        /**
         * 单例模式中获取唯一的MyApplication实例
         *
         * @return
         */
        val instance: App
            get() {
                if (null == myApplication) {
                    myApplication = App()
                }

                return myApplication as App
            }
    }

}