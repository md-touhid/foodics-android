package com.toptal.foodics.utils

import android.content.Context
import android.content.SharedPreferences
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.toptal.foodics.R

/**
 * Created by touhid on 26/Jan/2022.
 */
object Helper {

    fun loadImage(context: Context, url: String?, imageView: ImageView){
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(imageView);
    }
}