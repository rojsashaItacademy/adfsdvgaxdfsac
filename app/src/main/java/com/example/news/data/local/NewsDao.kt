package com.example.news.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.news.data.model.news.ArticleItem
import com.example.news.data.model.news.NewsModel

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add1(data: List<ArticleItem>)

    @Query("SELECT * FROM ArticleItem WHERE page = :page")
    fun getAll1(page: Int): List<ArticleItem>

    @Query("DELETE FROM ArticleItem")
    fun deleteAll1()

    @Transaction
    fun addForecast1(data: List<ArticleItem>) {
        deleteAll1()
//        add1(data)
    }
}