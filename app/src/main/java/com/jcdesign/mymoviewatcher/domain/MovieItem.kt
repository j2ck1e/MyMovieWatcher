package com.jcdesign.mymoviewatcher.domain

data class MovieItem(
    val countries: List<Country>,
    val description: String,
    val filmId: Int,
    val filmLength: String,
    val genres: List<Genre>,
    val nameEn: String? = "",
    val nameRu: String,
    val posterUrl: String,
    val posterUrlPreview: String? = "",
    val rating: String,
    val type: String,
    val webUrl: String,
    val year: String
)

