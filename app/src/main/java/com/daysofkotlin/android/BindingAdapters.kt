package com.daysofkotlin.android

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.daysofkotlin.android.network.Articles
import com.daysofkotlin.android.newsOverview.AllNewsAdapter

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Articles>?){
    data?.let {
        val adapter =recyclerView.adapter as AllNewsAdapter
        adapter.submitList(data)
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?){
    imageUrl?.let {
        Glide.with(imageView.context)
            .load(imageUrl)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image))
            .into(imageView)
    }
}