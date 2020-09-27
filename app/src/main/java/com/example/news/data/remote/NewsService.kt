package com.example.news.data.remote

import com.example.news.data.model.news.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("appid") appId: String
    ): NewsModel

}

//http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=512fac0f6c1f42a8984d0f1d8bb74733