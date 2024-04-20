package com.jsnow.prismbase.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * Author:JSnow
 * Date:2020/7/7 - 2:22 PM
 * Description:BaseVMActivity
 */
abstract class BaseVMActivity<VM : BaseViewModel, VB : ViewBinding> : BaseActivity<VB>() {
    private lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        createViewModel()
        lifecycle.addObserver(viewModel)
        super.onCreate(savedInstanceState)
    }

    @Suppress("UNCHECKED_CAST")
    private fun createViewModel() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val tp = type.actualTypeArguments[0]
            val clazz = tp as? Class<VM> ?: BaseViewModel::class.java
            viewModel = ViewModelProvider(this, ViewModelFactory()).get(clazz) as VM
        }
    }
}