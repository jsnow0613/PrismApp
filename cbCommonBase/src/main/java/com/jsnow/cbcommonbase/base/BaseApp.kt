package com.jsnow.cbcommonbase.base

import android.app.Application
import android.content.Context

/**
 * Author:bincheng
 * Date:2020/7/1 - 2:57 PM
 * Description:BaseApp
 */
open class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Companion.appContext = applicationContext

    }

    companion object {
        lateinit var appContext: Context
    }
}