package com.jcdesign.mymoviewatcher.domain

interface MovieListRepository {

    fun getMovieList(): List<MovieItem>

    fun getMovieItem(movieItemId: Int): MovieItem
}