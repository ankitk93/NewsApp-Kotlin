package com.daysofkotlin.android.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
@Parcelize
data class Articles(@Json(name = "author") val author: String?,
               @Json(name = "title") val title: String,
               @Json(name = "description") val description: String,
               @Json(name = "url") val url: String,
               @Json(name = "urlToImage")val imageUrl: String,
               @Json(name = "publishedAt")val publishedAt: String,
               @Json(name = "source")val source: Source, @Json(name = "content")val content:String?) : Parcelable{
}