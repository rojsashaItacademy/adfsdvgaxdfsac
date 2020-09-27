package com.example.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news.R
import com.example.news.data.model.news.ArticleItem
import com.example.news.ui.main.MainActivity.Companion.ARTICLE

class NewsArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_article)
        val data = intent.getParcelableExtra<ArticleItem>(ARTICLE)
    }
}