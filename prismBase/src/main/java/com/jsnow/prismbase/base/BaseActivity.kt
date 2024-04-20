package com.jsnow.prismbase.base

import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.jsnow.mybase.utils.BarUtil
import com.jsnow.prismbase.R
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<DB : ViewBinding> : AppCompatActivity() {
    val TAG: String by lazy {
        javaClass.simpleName
    }

    protected lateinit var mBinding: DB

    private var dialog: MaterialDialog? = null

    open val layoutId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBar()
        initViewDataBinding()
        initView(savedInstanceState)
        initObserve()
        initData()
    }

    abstract fun initView(savedInstanceState: Bundle?)
    open fun initObserve() {}
    abstract fun initData()

    private fun setStatusBar() {
        BarUtil.transparentStatusBar(this)

        // 透明状态栏
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        // 透明导航栏
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    }

    /**
     * DataBinding or ViewBinding
     */
    private fun initViewDataBinding() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val cls = type.actualTypeArguments
                .map { it as Class<*> }
                .first { ViewBinding::class.java.isAssignableFrom(it) }
            when {
                ViewDataBinding::class.java.isAssignableFrom(cls) && cls != ViewDataBinding::class.java -> {
                    if (layoutId == 0) throw IllegalArgumentException("Using DataBinding requires overriding method layoutId")
                    mBinding = DataBindingUtil.setContentView(this, layoutId)
                    (mBinding as ViewDataBinding).lifecycleOwner = this
                }

                ViewBinding::class.java.isAssignableFrom(cls) && cls != ViewBinding::class.java -> {
                    cls.getDeclaredMethod("inflate", LayoutInflater::class.java).let {
                        @Suppress("UNCHECKED_CAST")
                        mBinding = it.invoke(null, layoutInflater) as DB
                        setContentView(mBinding.root)
                    }
                }

                else -> {
                    if (layoutId == 0) throw IllegalArgumentException("If you don't use ViewBinding, you need to override method layoutId")
                    setContentView(layoutId)
                }
            }
        } else throw IllegalArgumentException("Generic error")
    }
    /**
     * 打开等待框
     */
    protected fun showLoading() {
        dialog ?: MaterialDialog(this)
            .cancelable(false)
            .cornerRadius(5f)
            .customView(R.layout.custom_progress_dialog_view, noVerticalPadding = true)
            .lifecycleOwner(this)
            .maxWidth(R.dimen.dimen_120).also {
                dialog = it
            }
            .also {
                it.window?.setDimAmount(0.7f)
                it.view.setBackgroundColor(Color.TRANSPARENT)
            }.show()
    }

    /**
     * 关闭等待框
     */
    protected fun dismissLoading() {
        dialog?.run { if (isShowing) dismiss() }
    }

    protected fun canDialogCancle(callback: (() -> Unit)? = null) {
        dialog?.setOnKeyListener { dialog, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                dialog.dismiss()
                callback?.invoke()
                true
            }
            false
        }
    }

    fun finishMe() {
        finish()
    }
}