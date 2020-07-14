package com.jsnow.prismbase.tools

import android.util.Log
import com.jsnow.prismbase.BuildConfig

val showLog: Boolean = BuildConfig.DEBUG
fun String.logD(tag: String) {
    if (showLog) {
        Log.d(tag, this)
    }
}

fun Int.logD(tag: String) {
    if (showLog) {
        Log.d(tag, this.toString())
    }
}

fun Float.logD(tag: String) {
    if (showLog) {
        Log.d(tag, this.toString())
    }
}

fun String.logE(tag: String) {
    if (showLog) {
        Log.e(tag, this)
    }
}

fun Int.logE(tag: String) {
    if (showLog) {
        Log.e(tag, this.toString())
    }
}

fun Float.logE(tag: String) {
    if (showLog) {
        Log.e(tag, this.toString())
    }
}