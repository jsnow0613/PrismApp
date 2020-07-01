package com.jsnow.cbnetwork

/**
 * Author:bincheng
 * Date:2020/5/9 - 2:58 PM
 * Description:返回数据响应的基类
 */
data class BaseResp<T>(
    val code: Int = 0,
    val msg: String = "",
    val data: T
)