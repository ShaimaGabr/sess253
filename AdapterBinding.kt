package com.example.sess25

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object AdapterBinding {
    @JvmStatic
    @BindingAdapter("hamada")
    fun loadimage(image:ImageView,url:String){
        Picasso.get().load(url).into(image)
    }
}