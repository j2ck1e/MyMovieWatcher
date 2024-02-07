package com.jcdesign.mymoviewatcher.data.datasource

import androidx.lifecycle.LiveData
import com.jcdesign.mymoviewatcher.data.network.model.MovieItemDto
import com.jcdesign.mymoviewatcher.data.network.model.SearchMoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RemoteDataSource {

    suspend fun getListMovie(
        word: String,
        page: String,
    ): SearchMoviesDto


    suspend fun getMovieById(
        movieId: String
    ): MovieItemDto
}