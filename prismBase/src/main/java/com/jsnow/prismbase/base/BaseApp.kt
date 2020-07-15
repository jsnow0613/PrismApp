package com.jsnow.prismbase.base

import android.app.Application
import android.content.Context
import com.jsnow.prismbase.tools.CrashManager

/**
 * Author:bincheng
 * Date:2020/7/1 - 2:57 PM
 * Description:BaseApp
 */
open class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        CrashManager.init()
    }

    companion object {
        lateinit var appContext: Context
    }
}