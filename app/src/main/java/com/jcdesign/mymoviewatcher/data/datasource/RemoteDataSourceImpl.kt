package com.jcdesign.mymoviewatcher.data.datasource

import androidx.lifecycle.LiveData
import com.jcdesign.mymoviewatcher.data.network.ApiFactory
import com.jcdesign.mymoviewatcher.data.network.ApiService
import com.jcdesign.mymoviewatcher.data.network.model.FilmDto
import com.jcdesign.mymoviewatcher.data.network.model.MovieItemDto
import com.jcdesign.mymoviewatcher.data.network.model.SearchMoviesDto

class RemoteDataSourceImpl(

) : RemoteDataSource {

    private val apiFactory = ApiFactory.getRetrofitInstance()

    override suspend fun getListMovie(
        word: String,
        page: String
    ): SearchMoviesDto {
        return apiFactory.getListMovie(word, page)
    }

    override suspend fun getMovieById(
        movieId: String
    ): MovieItemDto {
        return apiFactory.getMovieById(movieId)
    }
}