package com.example.news.data.model.news

import androidx.room.Entity
import androidx.room.PrimaryKey

data class NewsModel(
    val id: Int,
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleItem>
)


