package com.jsnow.baseapp.guide

import androidx.viewpager2.widget.ViewPager2
import com.jsnow.baseapp.R
import com.jsnow.cbtools.interfaces.ContentLayout
import com.jsnow.cbtools.base.BaseActivity
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

@ContentLayout(R.layout.activity_guide)
class GuideActivity : BaseActivity() {
    private val imgs = arrayOf(
        R.drawable.ic_avatar,
        R.drawable.ic_avatar,
        R.drawable.ic_avatar,
        R.drawable.ic_avatar
    )

    override fun initViews() {
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = IndicatorAdapter(imgs)

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dotIndicator)
        dotsIndicator.setViewPager2(viewPager)
    }

    override fun initDatas() {}

}