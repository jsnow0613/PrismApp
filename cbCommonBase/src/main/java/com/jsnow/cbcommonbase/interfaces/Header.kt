package com.jsnow.cbcommonbase.interfaces

/**
 * Author:bincheng
 * Date:2020/7/2 - 11:46 AM
 * Description:Header
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Header(val title: String="标题")