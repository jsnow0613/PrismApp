package com.jsnow.prism.ui.guide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jsnow.prism.R
import java.util.Timer
import java.util.TimerTask

class GuideActivity : AppCompatActivity() {
    private val countDownTime = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        startCountDown()
    }

    /*
    实现倒计时 2s 后跳转到 MainActivity
     */
    private fun startCountDown() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                finish()
            }
        }, countDownTime.toLong())
    }
}