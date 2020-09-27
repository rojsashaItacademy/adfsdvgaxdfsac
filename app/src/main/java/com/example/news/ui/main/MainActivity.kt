package com.example.news.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news.R
import com.example.news.data.model.news.NewsModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter: RvAdapter? = null
    private var presenter:MainPresenter? = null

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

    private fun getBusinessNews(){
        presenter?.getBusinessNews()
    }

    //        presenter?.getSavedData()?.observe(this, androidx.lifecycle.Observer {
//            if (it.isNotEmpty()) {
//                val item = it.first()
//                adapter.update(item.daily)
//            } })

    override fun fillView(result: NewsModel?) {
        runOnUiThread{
            adapter?.update(result?.articles)
         //   presenter?.itemClicks(result?.articles)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.unbind()
    }
}