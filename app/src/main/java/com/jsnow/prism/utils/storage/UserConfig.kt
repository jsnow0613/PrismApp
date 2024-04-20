package com.jsnow.prism.utils.storage;

import com.drake.serialize.serialize.annotation.SerializeConfig;
import com.drake.serialize.serialize.serialLazy

/**
  @author : jsnow
 * @Date : 2024/4/21 00:37
 */

@SerializeConfig(mmapID = "user_config")
object UserConfig {
    var token :String by serialLazy("",)
    var isLogin :Boolean by serialLazy(false)
}
