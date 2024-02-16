package com.jcdesign.mymoviewatcher.domain

import androidx.lifecycle.LiveData

class GetMovieListUseCase(
    private val movieListRepository: MovieListRepository
) {

    suspend operator fun invoke(keyword: String, page: String): LiveData<SearchMovies> {
        return movieListRepository.getMovieList(keyword, page)
    }
}