package com.example.news.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.news.data.model.news.NewsModel

@Dao
interface NewsDao {

    @Insert
    fun add(data:NewsModel)

    @Query("SELECT * FROM NewsModel")
    fun getAll() : LiveData<List<NewsModel>>

    @Query("DELETE FROM NewsModel")
    fun deleteAll()

    @Transaction
    fun addForecast(data: NewsModel){
        deleteAll()
        add(data)
    }
}