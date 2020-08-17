package com.jsnow.prismstorage.shareprefrence

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

/**
 * Author:bincheng
 * Date:2020/7/1 - 2:51 PM
 * Description:SPUtils
 */
class SPUtils private constructor(mContext: Application) {

    companion object {
        fun getInstance(context: Application) = SPUtils(context)
        private const val KEY_IS_FIRST_OPEN = "key_is_first_open"
        private val SP_NAME = "App_config"
        private val KEY_TOKEN = "key_token"
    }


    private val prefs: SharedPreferences by lazy {
        mContext.getSharedPreferences(
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
        val isFisrtOpen = prefs.getBoolean(Companion.KEY_IS_FIRST_OPEN, true)
        if (isFisrtOpen) {
            prefs.edit().putBoolean(Companion.KEY_IS_FIRST_OPEN, false).apply()
            return 1
        } else {
            return if (getToken().isNotEmpty()) {
                3
            } else {
                2
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