package com.jcdesign.mymoviewatcher.domain

data class SearchMovies(
    val films: List<Film>,
    val keyword: String,
    val pagesCount: Int,
    val searchFilmsCountResult: Int
)



