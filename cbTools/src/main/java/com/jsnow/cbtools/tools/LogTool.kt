package com.jsnow.cbtools.tools

import android.util.Log
import com.jsnow.cbtools.BuildConfig

val showLog: Boolean = BuildConfig.DEBUG
fun String.logd(tag: String) {
    if (showLog) {
        Log.d(tag, this)
    }
}

fun Int.logd(tag: String) {
    if (showLog) {
        Log.d(tag, this.toString())
    }
}

fun Float.logd(tag: String) {
    if (showLog) {
        Log.d(tag, this.toString())
    }
}