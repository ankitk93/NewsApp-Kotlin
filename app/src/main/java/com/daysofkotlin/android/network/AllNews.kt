package com.daysofkotlin.android.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
@Parcelize
data class AllNews(@Json(name = "status") val status: String,
                   @Json(name = "totalResults") val totalResult: Int,
                   @Json(name = "articles") val articles: List<Articles>): Parcelable {
}