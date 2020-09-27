package com.example.news.data

import androidx.paging.PageKeyedDataSource
import com.example.news.BuildConfig
import com.example.news.data.model.news.ArticleItem
import com.example.news.data.remote.RetrofitBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsDataSource: PageKeyedDataSource<Int, ArticleItem>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ArticleItem>
    ) {
        GlobalScope.launch {
            runCatching {
                val result = RetrofitBuilder.getService()?.getNews("us", "business",
                    BuildConfig.API_KEY_NEWS, 1, 10)

                result?.articles?.let { callback.onResult(it, 1, 2) }

            }
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleItem>) {
        GlobalScope.launch {
            runCatching {
                val result = RetrofitBuilder.getService()?.getNews("us", "business",
                    BuildConfig.API_KEY_NEWS,  params.key, 10)

                result?.articles?.let { callback.onResult(it, params.key + 1) }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleItem>) {
    }
}