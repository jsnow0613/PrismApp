package com.jsnow.cbcommonbase.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Author:bincheng
 * Date:2020/7/7 - 1:42 PM
 * Description:ViewModelFactory
 */
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.newInstance()
    }
}