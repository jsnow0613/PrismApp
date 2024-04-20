package com.jsnow.prismbase.base

import android.app.Application
import android.content.Context
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.request.CachePolicy
import com.drake.engine.base.Engine

/**
 * Author:bincheng
 * Date:2020/7/1 - 2:57 PM
 * Description:BaseApplication
 */
open class BaseApplication : Application() , ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        Engine.initialize(this)
    }

    companion object {
        lateinit var appContext: Context
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(applicationContext)
            .crossfade(true)
            .networkCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .allowHardware(true)
            .allowRgb565(true)
            .build()
    }
}