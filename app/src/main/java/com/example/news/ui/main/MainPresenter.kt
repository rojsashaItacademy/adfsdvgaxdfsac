package com.example.news.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.news.BuildConfig.API_KEY_NEWS
import com.example.news.NewsApp
import com.example.news.data.NewsDataSource
import com.example.news.data.model.news.ArticleItem
import com.example.news.data.model.news.NewsModel
import com.example.news.data.remote.RetrofitBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter : MainContract.Presenter  {

    private var view: MainContract.View? = null

    var postsLiveData: LiveData<PagedList<ArticleItem>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(15)
            .setInitialLoadSizeHint(30)
            .setEnablePlaceholders(false)
            .build()
        postsLiveData = initializedPagedListBuilder(config).build()
    }

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<Int, ArticleItem> {

        val dataSourceFactory = object : DataSource.Factory<Int, ArticleItem>() {
            override fun create(): DataSource<Int, ArticleItem> {
                return NewsDataSource()
            }
        }

        return LivePagedListBuilder(dataSourceFactory, config)
    }

    override fun getBusinessNews() {
//        GlobalScope.launch {
//            runCatching {
//                val result = RetrofitBuilder.getService()?.getNews("us", "business", API_KEY_NEWS, 1, 1)
//                updateDB(result)
//                view?.fillView(result)
//            }.onFailure {
//                Log.d("NETWORK", "NO DATA")
//            }
//        }
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

}