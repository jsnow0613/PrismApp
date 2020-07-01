package com.jsnow.cbtools.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    val TAG: String by lazy {
        javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        if (isFullWindow()) {
            setStatusBar()
        }
        setContentView(setLayoutResourceID())
        initViews()
        initDatas()
    }

    abstract fun setLayoutResourceID(): Int
    abstract fun initViews()
    abstract fun initDatas()

    open fun isFullWindow(): Boolean {
        return false
    }

    //设置沉浸式状态栏
    private fun setStatusBar() {
        // 透明状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 透明导航栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }
}