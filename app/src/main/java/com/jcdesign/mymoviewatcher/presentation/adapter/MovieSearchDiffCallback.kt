package com.jcdesign.mymoviewatcher.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jcdesign.mymoviewatcher.domain.Film
import com.jcdesign.mymoviewatcher.domain.MovieItem

object MovieSearchDiffCallback: DiffUtil.ItemCallback<Film>() {

    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.filmId == newItem.filmId
    }

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem == newItem
    }
}