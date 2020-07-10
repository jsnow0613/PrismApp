package com.jsnow.cbcommonbase.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import com.jsnow.cbcommonbase.interfaces.ContentLayout
import com.jsnow.cbcommonbase.tools.logD
import com.jsnow.cbcommonbase.tools.logE
import com.jsnow.cbcommonbase.tools.showToast
import java.lang.reflect.ParameterizedType

/**
 * Author:bincheng
 * Date:2020/7/10 - 3:03 PM
 * Description:BaseFragment
 */
abstract class BaseFragment<VM : BaseViewModel> : Fragment() {
    protected lateinit var viewModel: VM

    //是否第一次加载
    private var isFirst: Boolean = true

    private lateinit var rootView: View
    val TAG: String by lazy {
        javaClass.simpleName
    }

    var layoutResId = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initAttributes()
        rootView = inflater.inflate(layoutResId, container, false)
        return rootView
    }

    private fun initAttributes() {
        val contentLayout = javaClass.getAnnotation(ContentLayout::class.java)
        contentLayout?.let {
            if (contentLayout.value != -1) {
                layoutResId = contentLayout.value
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createViewModel()
        lifecycle.addObserver(viewModel)
        initView(savedInstanceState)
    }

    open fun initView(savedInstanceState: Bundle?) {}

    override fun onResume() {
        super.onResume()
        onVisible()
    }

    /**
     * 是否需要懒加载
     */
    private fun onVisible() {
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {
            lazyLoadData()
            isFirst = false
        }
    }


    /**
     * 懒加载
     */
    open fun lazyLoadData() {}

    abstract fun layoutId(): Int
    open fun isShareVM(): Boolean = false

    @Suppress("UNCHECKED_CAST")
    private fun createViewModel() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val tp = type.actualTypeArguments[0]
            val tClass = tp as? Class<VM> ?: BaseViewModel::class.java
            val viewModelStore = if (isShareVM()) activity!!.viewModelStore else this.viewModelStore
            viewModel = ViewModelProvider(viewModelStore, ViewModelFactory()).get(tClass) as VM
        }
    }


    open fun toast(text: String) {
        text.showToast()
    }

    open fun logD(text: String) {
        text.logD(TAG)
    }

    open fun logE(text: String) {
        text.logE(TAG)
    }
}