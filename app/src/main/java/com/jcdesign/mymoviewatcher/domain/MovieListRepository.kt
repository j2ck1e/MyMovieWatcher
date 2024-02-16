package com.jcdesign.mymoviewatcher.domain

import androidx.lifecycle.LiveData

interface MovieListRepository {

    suspend fun getMovieList(keyword: String, page: String): LiveData<SearchMovies>

    suspend fun getMovieItem(movieItemId: String): LiveData<MovieItem>
}