package com.example.news.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.data.model.news.ArticleItem
import kotlinx.android.synthetic.main.item_news.view.*

class RvAdapter(private val listener: RecyclerviewListener):RecyclerView.Adapter<RvHolder>() {

    val list = arrayListOf<ArticleItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return RvHolder(view)
    }

    fun update(list: List<ArticleItem>?){
        if (list != null){
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RvHolder, position: Int) {
        holder.bind(list[position], listener)
    }
}

class RvHolder(view: View):RecyclerView.ViewHolder(view){
    fun bind(
        articleItem: ArticleItem,
        listener: RecyclerviewListener
    ) {

        itemView.tvDesc.text = articleItem.author

        itemView.setOnClickListener{
            listener.itemClicks(articleItem)
        }


    }
}