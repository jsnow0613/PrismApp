package com.jsnow.cbcommonbase.interfaces

/**
 * Author:bincheng
 * Date:2020/7/2 - 11:28 AM
 * Description:ContentLayoutID
 */

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ContentLayout(val value: Int = -1)