package com.jsnow.cbcommonbase.tools

import android.view.View
import cn.pedant.SweetAlert.SweetAlertDialog
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ColorUtils
import com.jsnow.cbcommonbase.R

/**
 * Author:bincheng
 * Date:2020/7/6 - 3:30 PM
 * Description:ProgressViewUtil
 */
object DialogTool {
    private lateinit var progressDialog: SweetAlertDialog
    private lateinit var normalDialog: SweetAlertDialog
    private lateinit var singleConformDialog: SweetAlertDialog
    private lateinit var customDialog: SweetAlertDialog
    fun showProgressDialog() {
        progressDialog =
            SweetAlertDialog(ActivityUtils.getTopActivity(), SweetAlertDialog.PROGRESS_TYPE)
        progressDialog.progressHelper.barColor = ColorUtils.getColor(R.color.colorPrimary)
        progressDialog.titleText = "loading..."
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    fun dismissDialog() {
        if (progressDialog.isShowing) {
            progressDialog.dismissWithAnimation()
        }
    }

    fun showCustomDialog(view: View) {
        customDialog =
            SweetAlertDialog(ActivityUtils.getTopActivity(), SweetAlertDialog.NORMAL_TYPE)
        customDialog.setCustomView(view)
        customDialog.show()
    }

    fun showSingleConfirmButtonDialog(
        title: String,
        content: String,
        listener: SweetAlertDialog.OnSweetClickListener
    ) {
        singleConformDialog = SweetAlertDialog(ActivityUtils.getTopActivity())
        singleConformDialog.setTitleText(title)
            .setContentText(content)
            .setConfirmButton("确定", listener)
            .show()
    }

    fun showSingleCancelButtonDialog(
        title: String,
        content: String,
        listener: SweetAlertDialog.OnSweetClickListener
    ) {
        singleConformDialog = SweetAlertDialog(ActivityUtils.getTopActivity())
        singleConformDialog.setTitleText(title)
            .setContentText(content)
            .setConfirmButton("取消", listener)
            .show()
    }

    fun showDoubleButtonDialog(
        title: String,
        content: String,
        listener: SweetAlertDialog.OnSweetClickListener
    ) {
        normalDialog = SweetAlertDialog(ActivityUtils.getTopActivity())
        normalDialog.setTitleText(title)
            .setContentText(content)
            .setConfirmButton("确定", listener)
            .setCancelText("取消")
            .show()
    }

}