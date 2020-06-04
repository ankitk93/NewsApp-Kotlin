package com.daysofkotlin.android.newsOverview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.daysofkotlin.android.databinding.NewsItemsBinding
import com.daysofkotlin.android.network.Articles

/**
 * Created by ak93.droid@gmail.com on 04,June,2020
 */
class AllNewsAdapter(private val onClickListener: OnClickListener): ListAdapter<Articles, AllNewsAdapter.AllNewsViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllNewsViewHolder {
        return AllNewsViewHolder(NewsItemsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AllNewsViewHolder, position: Int) {
        val articles = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(articles) }
        holder.bind(articles)
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Articles>(){
        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }

    }

    class AllNewsViewHolder(private var binding: NewsItemsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(articles: Articles){
            binding.articles = articles
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (articles: Articles) -> Unit){
        fun onClick(articles:Articles) = clickListener(articles)
    }
}