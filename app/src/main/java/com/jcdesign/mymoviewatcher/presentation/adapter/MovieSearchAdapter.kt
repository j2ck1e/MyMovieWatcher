package com.jcdesign.mymoviewatcher.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.jcdesign.mymoviewatcher.databinding.ItemSearchMovieBinding
import com.jcdesign.mymoviewatcher.domain.Film
import com.jcdesign.mymoviewatcher.domain.Genre
import com.jcdesign.mymoviewatcher.domain.MovieItem


class MovieSearchAdapter : ListAdapter<Film, MovieSearchViewHolder>(MovieSearchDiffCallback) {

    var onItemClickListener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSearchViewHolder {
        val binding =
            ItemSearchMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieSearchViewHolder, position: Int) {
        val movieItem = getItem(position)
        with(holder.binding) {
            Glide.with(holder.itemView).load(movieItem.posterUrl).into(ivPoster)
            movieRuName.text = movieItem.nameRu
            movieEnName.text = movieItem.nameEn
            movieYear.text = "${movieItem.year}, ${listGenreToString(movieItem.genres)}"
            movieRating.text = movieItem.rating
            root.setOnClickListener {
                onItemClickListener?.onMovieItemClick(movieItem)
            }

        }
    }

    interface OnItemClickListener {
        fun onMovieItemClick(movieItem: Film)
    }

    private fun listGenreToString(list: List<Genre>): String {
        val listOfString = mutableListOf<String>()
        for(i in list){
            i.genre?.let { listOfString.add(it) }
        }
        return listOfString.joinToString()
    }

}