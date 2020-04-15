package com.jsnow.baseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import com.jsnow.cbtools.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val list = arrayOf("reified")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    startActivity<SecondActivity>(this){
                        putExtra(SecondActivity.param1,"from main to second")
                    }
                }
                else -> {
                }
            }
        }
    }
}