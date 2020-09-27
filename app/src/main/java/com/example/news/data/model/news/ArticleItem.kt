package com.example.news.data.model.news

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String?,
    var page: Int = 0,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
    val source: SourceModel?
)
