package com.jcdesign.mymoviewatcher.domain

import javax.inject.Inject

class GetMovieItemUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(itemId: String) =
        movieRepository.getMovieItem(itemId)

}