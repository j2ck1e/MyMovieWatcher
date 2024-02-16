package com.jcdesign.mymoviewatcher.data

import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSourceImpl
import com.jcdesign.mymoviewatcher.data.mapper.Mapper
import com.jcdesign.mymoviewatcher.domain.MovieItem
import com.jcdesign.mymoviewatcher.domain.MovieRepository
import com.jcdesign.mymoviewatcher.domain.SearchMovies
import java.lang.Exception

class MovieRepositoryImpl(

) : MovieRepository {

    private val remoteDataSource = RemoteDataSourceImpl()
    private val mapper = Mapper()


    override suspend fun getMovieItem(itemId: String): MovieItem {
        try {
            val itemDto = remoteDataSource.getMovieById(itemId)
            return mapper.mapMovieItemDtoToMovieItemEntity(itemDto)
        } catch (_: Exception){

        }
        throw RuntimeException("Internet has not been available")
    }

    override suspend fun getMovieList(keyword: String, page: String): SearchMovies {
        try {
            val moviesDto = remoteDataSource.getListMovie(keyword, page)
            return mapper.mapSearchMoviesDtoToSearchMoviesEntity(moviesDto)
        } catch (_: Exception){

        }
        throw RuntimeException("Internet has not been available")
    }


}