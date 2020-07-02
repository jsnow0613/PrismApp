package com.jsnow.cbtools.interfaces

/**
 * Author:bincheng
 * Date:2020/7/2 - 11:16 AM
 * Description:FullScreen
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FullScreen(val value: Boolean = true)