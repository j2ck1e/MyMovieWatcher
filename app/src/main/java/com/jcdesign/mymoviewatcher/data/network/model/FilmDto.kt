package com.jcdesign.mymoviewatcher.data.network.model

data class FilmDto(
    val countries: List<CountryDto>,
    val description: String,
    val filmId: Int,
    val filmLength: String,
    val genres: List<GenreDto>,
    val nameEn: String,
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String,
    val rating: String,
    val ratingVoteCount: Int,
    val type: String,
    val year: String
)