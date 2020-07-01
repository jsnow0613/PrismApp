package com.jsnow.baseapp.guide

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.jsnow.baseapp.R
import com.jsnow.cbtools.base.BaseActivity
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class GuideActivity : BaseActivity() {
    private val imgs = arrayOf(
        R.drawable.ic_avatar,
        R.drawable.ic_avatar,
        R.drawable.ic_avatar,
        R.drawable.ic_avatar
    )

    override fun setLayoutResourceID(): Int {
        return R.layout.activity_guide
    }

    override fun initViews() {
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = IndicatorAdapter(imgs)

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dotIndicator)
        dotsIndicator.setViewPager2(viewPager)
    }

    override fun initDatas() {
        TODO("Not yet implemented")
    }
}