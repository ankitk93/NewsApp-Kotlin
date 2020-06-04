package com.daysofkotlin.android.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
@Parcelize
 data class Source(@Json(name = "id") val id: String, @Json(name = "name")val name: String): Parcelable{
}