package com.jsnow.cbtools.base

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.jsnow.cbtools.R
import com.jsnow.cbtools.interfaces.ContentLayout
import com.jsnow.cbtools.interfaces.FullScreen
import com.jsnow.cbtools.interfaces.Header
import com.jsnow.cbtools.views.HeaderView

abstract class BaseActivity : AppCompatActivity() {
    val TAG: String by lazy {
        javaClass.simpleName
    }
    var isFullScreen = false

    var layoutResId = 1
    lateinit var headerView: HeaderView
    lateinit var title: String
    var hasTitleView = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isImmersionBar()) {
            setStatusBar()
        }
        initAttributes()
        initContentLayout()
        initViews()
        initDatas()
    }

    private fun initContentLayout() {
        if (hasTitleView) {
            val headerContentLayout =
                layoutInflater.inflate(R.layout.content_layout_header, null, false) as LinearLayout
            headerView = headerContentLayout.findViewById<HeaderView>(R.id.header)
            headerView.setTitle(title)

            val contentLayout = layoutInflater.inflate(layoutResId, null, false)
            headerContentLayout.addView(contentLayout)
            setContentView(headerContentLayout)
        } else {
            setContentView(layoutResId)
        }
    }

    private fun initAttributes() {
        try {
            val fullScreen = javaClass.getAnnotation(FullScreen::class.java)
            val contentLayout = javaClass.getAnnotation(ContentLayout::class.java)
            val headerLayout = javaClass.getAnnotation(Header::class.java)

            if (fullScreen != null) {
                isFullScreen = fullScreen.value
                if (isFullScreen) {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                }
            }

            if (contentLayout != null) {
                if (contentLayout.value != -1) {
                    layoutResId = contentLayout.value
                }
            }

            if (headerLayout != null) {
                title = headerLayout.title
                hasTitleView = true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    abstract fun initViews()
    abstract fun initDatas()

    open fun isImmersionBar(): Boolean {
        return true
    }

    //设置沉浸式状态栏
    private fun setStatusBar() {
        // 透明状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        // 透明导航栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    }
}