package com.jcdesign.mymoviewatcher.domain

class GetMovieListUseCase(
    private val movieListRepository: MovieListRepository
) {

    operator fun invoke(): List<MovieItem> {
        return movieListRepository.getMovieList()
    }
}