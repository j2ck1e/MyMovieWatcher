package com.jcdesign.mymoviewatcher.domain

interface MovieRepository {

    suspend fun getMovieItem(itemId: String) : MovieItem
    suspend fun getMovieList(keyword: String, page: String): SearchMovies
}