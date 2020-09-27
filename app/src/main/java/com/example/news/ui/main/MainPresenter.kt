package com.example.news.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.news.BuildConfig.API_KEY_NEWS
import com.example.news.NewsApp
import com.example.news.data.model.news.ArticleItem
import com.example.news.data.model.news.NewsModel
import com.example.news.data.remote.RetrofitBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter : MainContract.Presenter, RecyclerviewListener {

    private var view: MainContract.View? = null

    override fun getBusinessNews() {
        GlobalScope.launch {
            runCatching {
                val result = RetrofitBuilder.getService()?.getNews("us", "business", API_KEY_NEWS)
                updateDB(result)
                view?.fillView(result)
            }.onFailure {
                Log.d("NETWORK", "NO DATA")
            }
        }
    }

    override fun getSavedData(): LiveData<List<NewsModel>>? {
        return NewsApp.getApp()?.getDb()?.getDao()?.getAll()
    }

    private fun updateDB(result: NewsModel?) {
        result?.let { NewsApp.getApp()?.getDb()?.getDao()?.addForecast(it) }
    }

    override fun bind(view: MainContract.View) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }

    override fun itemClicks(item: ArticleItem) {

    }


}