package com.jsnow.mybase.utils

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.view.Window
import android.view.WindowManager


/**
 * @author : jsnow
 * @Date : 2023/5/29 22:37
 */
object BarUtil {
    fun transparentStatusBar(activity: Activity) {
        transparentStatusBar(activity.window)
    }

    private fun transparentStatusBar(window: Window) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val vis = window.decorView.systemUiVisibility
        window.decorView.systemUiVisibility = option or vis
        window.statusBarColor = Color.TRANSPARENT
    }
}