package com.jsnow.prism.guide

import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.jsnow.prism.R
import com.jsnow.prismbase.base.BaseActivity
import com.jsnow.prismbase.annotation.ContentLayout
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

@ContentLayout(R.layout.activity_guide)
class GuideActivity : BaseActivity() {
    private var button: Button? = null
    private val imgs = arrayOf(
        R.drawable.ic_avatar,
        R.drawable.ic_avatar,
        R.drawable.ic_avatar,
        R.drawable.ic_avatar
    )

    override fun initViews() {
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = IndicatorAdapter(imgs)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == imgs.size - 1) {
                    button?.visibility = View.VISIBLE
                } else {
                    button?.apply {
                        if (isVisible) {
                            visibility = View.GONE
                        }
                    }
                }
            }
        })

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dotIndicator)
        dotsIndicator.setViewPager2(viewPager)

        button = findViewById<Button>(R.id.button)
        button?.setOnClickListener {
            showProgressDialog()
            Handler(mainLooper).postDelayed({ dismissProgressDialog() }, 3000)
        }
    }

    override fun initDatas() {}

}