package com.jsnow.cbcommonbase

import android.content.Context
import android.content.Intent

/**
 * 知识点：
 * 1.inline
 * 2.reified
 */


inline fun <reified T> startActivity(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)
}

inline fun <reified T> startActivity(context: Context,block:Intent.()->Unit){
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}