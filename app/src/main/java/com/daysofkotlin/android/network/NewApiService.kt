package com.daysofkotlin.android.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */

private const val BASE_URL = "https://newsapi.org/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//retrofit
private val retrofit =Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface NewApiService{

    /**
     * function to get data from news api
     */
    @GET("top-headlines?language=en&pageSize=100&apiKey=3b255e69c52e42b4a6bf10faa92f03cb")
    fun getAllNews(): Deferred<AllNews>
}

object NewsApi{
    val retrofitService: NewApiService by lazy {
        retrofit.create(NewApiService::class.java)
    }
}