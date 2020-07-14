package com.jsnow.prismbase.base

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import com.blankj.utilcode.util.Utils

/**
 * Author:bincheng
 * Date:2020/7/6 - 5:38 PM
 * Description:BaseViewModel
 */
open class BaseViewModel : AndroidViewModel(Utils.getApp()), LifecycleObserver {

}