package com.example.news.ui.main

import androidx.lifecycle.LiveData
import com.example.news.data.model.news.NewsModel
import com.example.news.ui.LiveCycle

interface MainContract {

    interface View{
        fun fillView(result: NewsModel?)
    }

    interface Presenter:LiveCycle<View>{
        fun getBusinessNews()
//        fun getSavedData(): LiveData<List<NewsModel>>?

    }
}