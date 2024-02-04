package com.jcdesign.mymoviewatcher.data.network.model

data class SearchMoviesDto(
    val films: List<FilmDto>,
    val keyword: String,
    val pagesCount: Int,
    val searchFilmsCountResult: Int
)



