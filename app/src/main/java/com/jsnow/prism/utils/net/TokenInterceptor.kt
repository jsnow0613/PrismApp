package com.jsnow.prism.utils.net

import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.jsnow.prism.utils.storage.UserConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException
import java.lang.reflect.Type
import java.nio.charset.StandardCharsets


/**
 * @author : jsnow
 * @Date : 2023/6/25 10:27
 */
class TokenInterceptor(enable: Boolean) : Interceptor {
    private val mEnable: Boolean

    init {
        mEnable = enable
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response: Response = chain.proceed(request)
        if (!mEnable) {
            return response
        }
        val responseBody: ResponseBody? = response.body
        val source = responseBody?.source()
        source?.request(Long.MAX_VALUE) // Buffer the entire body.
        val buffer: okio.Buffer = source!!.buffer
        val data: String = buffer.clone().readString(StandardCharsets.UTF_8)
        val type: Type = object : TypeToken<BaseResult<Any?>?>() {}.getType()
        try {
            val (_, code) = GsonUtils.fromJson<BaseResult<Any>>(data, type)
            if (code == 1) {
                UserConfig.isLogin = false
                // TODO: jump to login
//                val activity = ActivityUtils.getTopActivity()
////                if (activity.localClassName!="ui.login.LoginActivity"){
////                    activity.jump<LoginActivity>()
////                }
            }
        } catch (e: JsonSyntaxException) {
            LogUtils.d("MyTokenInterceptor#intercept(), e: " + e.message)
        }
        return response
    }
}