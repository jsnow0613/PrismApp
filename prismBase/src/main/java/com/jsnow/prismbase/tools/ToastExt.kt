package com.jsnow.prismbase.tools

import android.widget.Toast
import com.blankj.utilcode.util.Utils

fun String.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(Utils.getApp(), this, duration).show()
}

fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(Utils.getApp(), this, duration).show()
}

fun Float.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(Utils.getApp(), this.toString(), duration).show()
}