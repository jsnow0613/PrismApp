package com.jsnow.cbstorage.shareprefrence

import android.content.Context
import android.content.SharedPreferences
import com.jsnow.cbtools.base.BaseApp

/**
 * Author:bincheng
 * Date:2020/7/1 - 2:51 PM
 * Description:SPUtils
 */
object SPUtils {
    private const val SP_NAME = "App_config"
    private const val KEY_TOKEN = "key_token"
    private const val KEY_IS_FIRST_OPEN = "key_is_first_open"

    private val prefs: SharedPreferences by lazy {
        BaseApp.appContext.getSharedPreferences(
            SP_NAME,
            Context.MODE_PRIVATE
        )
    }

    fun saveToken(value: String) {
        prefs.edit().putString(KEY_TOKEN, value).apply()
    }

    fun getToken(): String {
        return prefs.getString(KEY_TOKEN, "").toString()
    }

    fun getSplashStatus(): Int {
        //1.首次安装：引导页 -> 登录页面
        //2.非首次安装，未登录：登录页面
        //3.非首次安装，已登录：首页
        val isFisrtOpen = prefs.getBoolean(KEY_IS_FIRST_OPEN, true)
        if (isFisrtOpen) {
            prefs.edit().putBoolean(KEY_IS_FIRST_OPEN, false).apply()
            return 1
        } else {
            if (getToken().isNotEmpty()) {
                return 3
            } else {
                return 2
            }
        }
    }

    /**
     * 清除
     */
    fun clear() {
        prefs.edit().clear().apply()
    }

    /**
     * 删除某Key的值
     */
    fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }
}