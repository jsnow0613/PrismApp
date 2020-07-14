package com.jsnow.prismbase.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.jsnow.prismbase.annotation.ContentLayout
import com.jsnow.prismbase.tools.logD
import com.jsnow.prismbase.tools.logE
import com.jsnow.prismbase.tools.showToast

/**
 * Author:bincheng
 * Date:2020/7/10 - 3:03 PM
 * Description:BaseFragment
 */
abstract class BaseFragment : Fragment() {

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