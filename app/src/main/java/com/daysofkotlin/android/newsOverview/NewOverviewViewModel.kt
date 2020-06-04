package com.daysofkotlin.android.newsOverview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daysofkotlin.android.network.AllNews
import com.daysofkotlin.android.network.Articles
import com.daysofkotlin.android.network.NewsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
class NewOverviewViewModel: ViewModel() {

    private val _allNews = MutableLiveData<AllNews>()
    val allNews: LiveData<AllNews>
    get() = _allNews

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
    get() = _response

    private val _articles = MutableLiveData<Articles>()
    val articles: LiveData<Articles>
    get() = _articles

    private val _navigationToSelectedArticle = MutableLiveData<Articles>()
    val navigationToSelectedArticle: LiveData<Articles>
        get() = _navigationToSelectedArticle

    //coroutine
    private val viewModelJob = Job()

    //coroutine scope
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getAllNewsFromAPiService()
    }

    fun displayArticleDetails(article: Articles){
        _navigationToSelectedArticle.value = article
    }

    fun displayArticleDetailsComplete(){
        _navigationToSelectedArticle.value = null
    }

    private fun getAllNewsFromAPiService(){
        coroutineScope.launch {
            val getAllNewsDeferred = NewsApi.retrofitService.getAllNews()
            try {
                val newsResponse = getAllNewsDeferred.await()
                _allNews.value = newsResponse
                Log.e("responseFrom : ", "$newsResponse")
            }catch (exception : Exception){
                Log.e("responseFrom:", "${exception.message}")
            }
        }
    }
}