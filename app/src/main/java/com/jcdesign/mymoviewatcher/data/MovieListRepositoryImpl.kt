package com.jcdesign.mymoviewatcher.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSource
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSourceImpl
import com.jcdesign.mymoviewatcher.data.mapper.Mapper
import com.jcdesign.mymoviewatcher.domain.MovieItem
import com.jcdesign.mymoviewatcher.domain.MovieListRepository
import com.jcdesign.mymoviewatcher.domain.SearchMovies

class MovieListRepositoryImpl(
    private val remoteDataSource: RemoteDataSourceImpl,
    private val mapper: Mapper
): MovieListRepository {

    override suspend fun getMovieList(keyword: String, page: String) = MediatorLiveData<SearchMovies>()
        .apply {
        addSource(remoteDataSource.getListMovie(keyword, page)){
            mapper.mapSearchMoviesDtoToSearchMoviesEntity(it)
        }

    }

    override suspend fun getMovieItem(movieItemId: String) = MediatorLiveData<MovieItem>().apply {
        addSource(remoteDataSource.getMovieById(movieItemId)){
            mapper.mapMovieItemDtoToMovieItemEntity(it)
        }
    }
}