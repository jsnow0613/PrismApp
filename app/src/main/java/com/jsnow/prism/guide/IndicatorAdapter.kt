package com.jsnow.prism.guide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.jsnow.prism.R

/**
 * Author:bincheng
 * Date:2020/7/1 - 4:05 PM
 * Description:PagerAdapter
 */
class IndicatorAdapter(private val imgs: Array<Int>) :
    RecyclerView.Adapter<IndicatorAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.view_guide, parent, false)
        return MyViewHolder(item)
    }

    override fun getItemCount() = imgs.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(imgs[position])
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val mImageView: ImageView = view.findViewById(R.id.imageView)

        fun bindData(res: Int) {
            mImageView.setImageResource(res)
        }
    }

}