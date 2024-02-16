package com.jcdesign.mymoviewatcher.domain

class GetMovieItemUseCase(
    private val movieListRepository: MovieListRepository
) {
    operator fun invoke(movieItemId: Int): MovieItem {
        return movieListRepository.getMovieItem(movieItemId)
    }
}