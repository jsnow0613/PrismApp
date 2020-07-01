package com.jsnow.baseapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.jsnow.baseapp.guide.GuideActivity
import com.jsnow.cbstorage.shareprefrence.SPUtils
import com.jsnow.cbtools.base.BaseActivity
import com.jsnow.cbtools.tools.logd

class SplashActivity : BaseActivity() {
    private val SPLASH_TIME_OUT: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            checkStates()
            finish()
        }, SPLASH_TIME_OUT)
    }

    override fun setLayoutResourceID(): Int {
        return R.layout.activity_splash
    }

    override fun initViews() {}
    override fun initDatas() {
        TODO("Not yet implemented")
    }

    private fun checkStates() {
        //1.首次安装：引导页 -> 登录页面
        //2.非首次安装，未登录：登录页面
        //3.非首次安装，已登录：首页
        val splashStatus = SPUtils.getSplashStatus()
        splashStatus.logd("SplashActivity")
        when (1) {
            1 -> {
                startActivity(Intent(this, GuideActivity::class.java))
            }
            2 -> {

            }
            3 -> {

            }
        }
    }
}