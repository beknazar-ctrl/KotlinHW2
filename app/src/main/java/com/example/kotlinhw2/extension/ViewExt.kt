package com.example.kotlinhw2.extension

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

fun View.load(url:String){

    Glide.with(context).load(url).centerCrop().into(imageView)

}
