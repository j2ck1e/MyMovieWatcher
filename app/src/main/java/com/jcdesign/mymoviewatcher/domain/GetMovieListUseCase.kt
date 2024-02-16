package com.jcdesign.mymoviewatcher.domain

class GetMovieListUseCase(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(keyword: String, page: String) = movieRepository.getMovieList(keyword, page)

}