package com.daysofkotlin.android.newsDetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daysofkotlin.android.network.Articles

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
class NewsDetailsViewModel(article: Articles, app: Application): AndroidViewModel(app) {

    private val _selectedArticle = MutableLiveData<Articles>()
    val selectedArticle: LiveData<Articles>
    get() = _selectedArticle


    init {
        _selectedArticle.value = article
    }
}