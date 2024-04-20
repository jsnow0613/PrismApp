package com.jsnow.prism.utils.net

import android.view.View

import com.drake.net.Net
import com.drake.net.exception.ConvertException
import com.drake.net.exception.DownloadFileException
import com.drake.net.exception.HttpFailureException
import com.drake.net.exception.NetConnectException
import com.drake.net.exception.NetException
import com.drake.net.exception.NetSocketTimeoutException
import com.drake.net.exception.NoCacheException
import com.drake.net.exception.RequestParamsException
import com.drake.net.exception.ResponseException
import com.drake.net.exception.ServerResponseException
import com.drake.net.exception.URLParseException
import com.drake.net.interfaces.NetErrorHandler
import com.drake.tooltip.toast
import com.jsnow.prism.R
import com.jsnow.prismbase.base.BaseApplication
import com.jsnow.prismbase.tools.showToast
import java.net.UnknownHostException

/**
 * @author : jsnow
 * @Date : 2023/7/12 11:21
 */
class MyErrorHandler : NetErrorHandler {
    companion object DEFAULT : NetErrorHandler

    /**
     * 全局的网络错误处理
     *
     * @param e 发生的错误
     */
    override fun onError(e: Throwable) {
        val message = when (e) {
            is UnknownHostException -> BaseApplication.appContext.getString(R.string.net_host_error)
            is URLParseException -> BaseApplication.appContext.getString(R.string.net_url_error)
            is NetConnectException -> BaseApplication.appContext.getString(R.string.net_connect_error)
            is NetSocketTimeoutException -> BaseApplication.appContext.getString(
                R.string.net_connect_timeout_error,
                e.message
            )
            is DownloadFileException -> BaseApplication.appContext.getString(R.string.net_download_error)
            is ConvertException -> BaseApplication.appContext.getString(R.string.net_parse_error)
            is RequestParamsException -> {
                BaseApplication.appContext.getString(R.string.net_request_error)
            }
            is ServerResponseException -> BaseApplication.appContext.getString(R.string.net_server_error)
            is NullPointerException -> BaseApplication.appContext.getString(R.string.net_null_error)
            is NoCacheException -> BaseApplication.appContext.getString(R.string.net_no_cache_error)
            is ResponseException -> e.message
            is HttpFailureException -> BaseApplication.appContext.getString(R.string.request_failure)
            is NetException -> BaseApplication.appContext.getString(R.string.net_error)
            else -> BaseApplication.appContext.getString(R.string.net_other_error)
        }

        Net.debug(e)
        toast(message)
    }

    /**
     * 当你使用包含缺省页功能的作用域中发生错误将回调本函数处理错误
     *
     * @param e 发生的错误
     * @param view 缺省页, StateLayout或者PageRefreshLayout
     */
    override fun onStateError(e: Throwable, view: View) {
        when (e) {
            is ConvertException,
            is RequestParamsException,
            is ResponseException,
            is NullPointerException -> onError(e)
            else -> Net.debug(e)
        }
    }
}