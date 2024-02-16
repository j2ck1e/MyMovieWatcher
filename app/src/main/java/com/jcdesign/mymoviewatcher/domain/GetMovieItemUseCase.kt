package com.jcdesign.mymoviewatcher.domain

import androidx.lifecycle.LiveData

class GetMovieItemUseCase(
    private val movieListRepository: MovieListRepository
) {
    suspend operator fun invoke(movieItemId: String): LiveData<MovieItem> {
        return movieListRepository.getMovieItem(movieItemId)
    }
}