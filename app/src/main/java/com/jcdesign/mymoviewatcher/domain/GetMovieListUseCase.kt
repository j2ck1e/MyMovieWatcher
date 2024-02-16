package com.jcdesign.mymoviewatcher.domain

import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(keyword: String, page: String) = movieRepository.getMovieList(keyword, page)

}