package com.jsnow.prism.utils.net

/**
 * @author : jsnow
 * @Date : 2024/4/20 22:44
 */


/*
建议请求路径都写在一个单例类中, 方便查找和替换
*/
object Api {
    const val HOST = "http://127.0.0.1:8091"

    const val TEXT = "/text"
    const val DELAY = "/delay"
    const val UPLOAD = "/upload"
    const val GAME = "/game"
    const val DATA = "/data"
    const val ARRAY = "/array"
    const val CONFIG = "/config"
    const val USER_INFO = "/userInfo"
    const val TIME = "/time"
    const val Token = "/token"
}