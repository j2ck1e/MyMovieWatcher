package com.jcdesign.mymoviewatcher.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.jcdesign.mymoviewatcher.databinding.ItemMovieBinding
import com.jcdesign.mymoviewatcher.domain.Film


class MovieSearchAdapter : ListAdapter<Film, MovieSearchViewHolder>(MovieSearchDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSearchViewHolder {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieSearchViewHolder, position: Int) {
        val movieItem = getItem(position)
        with(holder.binding){
            Glide.with(holder.itemView).load(movieItem.posterUrl).into(ivPoster)
            movieRuName.text = movieItem.nameRu
            movieEnName.text = movieItem.nameEn
            movieYear.text = movieItem.year
            movieRating.text=movieItem.rating

        }
    }

}