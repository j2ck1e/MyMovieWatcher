package com.jcdesign.mymoviewatcher.data

import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSourceImpl
import com.jcdesign.mymoviewatcher.data.mapper.Mapper
import com.jcdesign.mymoviewatcher.domain.MovieItem
import com.jcdesign.mymoviewatcher.domain.MovieRepository
import com.jcdesign.mymoviewatcher.domain.SearchMovies
import java.lang.Exception
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val remoteDataSource: RemoteDataSourceImpl
) : MovieRepository {


    override suspend fun getMovieItem(itemId: String): MovieItem {

        val itemDto = remoteDataSource.getMovieById(itemId)
        return mapper.mapMovieItemDtoToMovieItemEntity(itemDto)

    }

    override suspend fun getMovieList(keyword: String, page: String): SearchMovies {

        val moviesDto = remoteDataSource.getListMovie(keyword, page)
        return mapper.mapSearchMoviesDtoToSearchMoviesEntity(moviesDto)

    }


}