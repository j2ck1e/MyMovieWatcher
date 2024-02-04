package com.jcdesign.mymoviewatcher.data.datasource

import androidx.lifecycle.LiveData
import com.jcdesign.mymoviewatcher.data.network.ApiFactory
import com.jcdesign.mymoviewatcher.data.network.ApiService
import com.jcdesign.mymoviewatcher.data.network.model.MovieItemDto
import com.jcdesign.mymoviewatcher.data.network.model.SearchMoviesDto

class RemoteDataSourceImpl(
    private val apiFactory: ApiFactory
) : RemoteDataSource {

    override suspend fun getListMovie(
        word: String,
        page: String
    ): LiveData<SearchMoviesDto> {
        return apiFactory.getRetrofitInstance().getListMovie(word, page)
    }

    override suspend fun getMovieById(
        movieId: String
    ): LiveData<MovieItemDto> {
        return apiFactory.getRetrofitInstance().getMovieById(movieId)
    }
}