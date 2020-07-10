package com.jsnow.baseapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.jsnow.baseapp.guide.GuideActivity
import com.jsnow.cbcommonbase.interfaces.ContentLayout
import com.jsnow.cbcommonbase.interfaces.FullScreen
import com.jsnow.cbcommonbase.tools.logE
import com.jsnow.cbstorage.shareprefrence.SPUtils

@ContentLayout(R.layout.activity_splash)
@FullScreen
class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(mainLooper).postDelayed({
            checkStates()
            finish()
        }, SPLASH_TIME_OUT)
    }

    private fun checkStates() {
        //1.首次安装：引导页 -> 登录页面
        //2.非首次安装，未登录：登录页面
        //3.非首次安装，已登录：首页
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