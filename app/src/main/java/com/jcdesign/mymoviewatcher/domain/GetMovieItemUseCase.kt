package com.jcdesign.mymoviewatcher.domain

class GetMovieItemUseCase(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(itemId: String) =
        movieRepository.getMovieItem(itemId)

}