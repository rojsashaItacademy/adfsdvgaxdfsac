package com.example.news.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.news.R
import com.example.news.data.model.news.ArticleItem
import com.example.news.data.model.news.NewsModel
import com.example.news.ui.NewsArticleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, RecyclerviewListener {

    private val adapter by lazy { RvAdapter(this) }
    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        presenter?.bind(this)
        getBusinessNews()
        setupRecycler()
    }

    private fun setupRecycler() {
        recyclerView.adapter = adapter
    }

    private fun getBusinessNews() {
        presenter?.postsLiveData?.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    override fun fillView(result: NewsModel?) {}

    override fun itemClicks(item: ArticleItem) {
        startActivity(Intent(this, NewsArticleActivity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unbind()
    }
}