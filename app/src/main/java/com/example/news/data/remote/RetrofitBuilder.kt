package com.example.news.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private var service: NewsService? = null

    fun getService(): NewsService? {
        if (service == null)
            service =
                buildRetrofit()

        return service
    }

    private fun buildRetrofit(): NewsService {
        val service =
            Retrofit.Builder()
                .baseUrl("http://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsService::class.java)

        return service
    }
}