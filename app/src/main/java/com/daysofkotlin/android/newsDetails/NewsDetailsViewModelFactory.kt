package com.daysofkotlin.android.newsDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daysofkotlin.android.network.Articles
import java.lang.IllegalArgumentException

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
class NewsDetailsViewModelFactory(private val articles: Articles,
                                  private val application: Application): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsDetailsViewModel::class.java)){
            return NewsDetailsViewModel(articles, application) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}