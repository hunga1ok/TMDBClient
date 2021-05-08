package com.huncorp.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.huncorp.tmdbclient.R
import com.huncorp.tmdbclient.data.model.tvShow.TvShow
import com.huncorp.tmdbclient.databinding.ListItemBinding

class TvAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private val tvList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvList.clear()
        tvList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvList[position])
    }

    override fun getItemCount(): Int {
        return tvList.size
    }
}

class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow) {
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.poster_path
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }

}