package com.jsnow.prism.utils.net

/**
 *   time   : 2019/11/01
 */
data class BaseResult<T>(
    val message: String,
    val code: Int,
    val data: T,
) : IBaseResponse<T> {

    override fun code() = code

    override fun msg() = message

    override fun data() = data

    override fun isSuccess() = code == 0

}