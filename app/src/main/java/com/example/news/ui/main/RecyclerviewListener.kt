package com.example.news.ui.main

import com.example.news.data.model.news.ArticleItem

interface RecyclerviewListener {
    fun itemClicks(item: ArticleItem)
}