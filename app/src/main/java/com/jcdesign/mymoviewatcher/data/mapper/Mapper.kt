package com.jcdesign.mymoviewatcher.data.mapper

import com.jcdesign.mymoviewatcher.data.network.model.CountryDto
import com.jcdesign.mymoviewatcher.data.network.model.FilmDto
import com.jcdesign.mymoviewatcher.data.network.model.GenreDto
import com.jcdesign.mymoviewatcher.data.network.model.MovieItemDto
import com.jcdesign.mymoviewatcher.data.network.model.SearchMoviesDto
import com.jcdesign.mymoviewatcher.domain.Country
import com.jcdesign.mymoviewatcher.domain.Film
import com.jcdesign.mymoviewatcher.domain.Genre
import com.jcdesign.mymoviewatcher.domain.MovieItem
import com.jcdesign.mymoviewatcher.domain.SearchMovies

class Mapper {

    fun mapSearchMoviesDtoToSearchMoviesEntity(searchMoviesDto: SearchMoviesDto) = SearchMovies(
        films = mapListFilmDtoToListFilmEntity(searchMoviesDto.films),
        keyword = searchMoviesDto.keyword,
        pagesCount = searchMoviesDto.pagesCount,
        searchFilmsCountResult = searchMoviesDto.searchFilmsCountResult,

    )

    fun mapMovieItemDtoToMovieItemEntity(movieItemDto: MovieItemDto) = MovieItem(
        completed = movieItemDto.completed,
        countries = mapListCountryDtoToListCountryEntity(movieItemDto.countries),
        coverUrl = movieItemDto.coverUrl,
        description = movieItemDto.description,
        editorAnnotation = movieItemDto.editorAnnotation,
        endYear = movieItemDto.endYear,
        filmLength = movieItemDto.filmLength,
        genres = mapListGenreDtoToListGenreEntity(movieItemDto.genres),
        has3D = movieItemDto.has3D,
        hasImax = movieItemDto.hasImax,
        imdbId = movieItemDto.imdbId,
        isTicketsAvailable = movieItemDto.isTicketsAvailable,
        kinopoiskHDId = movieItemDto.kinopoiskHDId,
        kinopoiskId = movieItemDto.kinopoiskId,
        lastSync = movieItemDto.lastSync,
        logoUrl = movieItemDto.logoUrl,
        nameEn = movieItemDto.nameEn,
        nameOriginal = movieItemDto.nameOriginal,
        nameRu = movieItemDto.nameRu,
        posterUrl = movieItemDto.posterUrl,
        posterUrlPreview = movieItemDto.posterUrlPreview,
        productionStatus = movieItemDto.productionStatus,
        ratingAgeLimits = movieItemDto.ratingAgeLimits,
        ratingAwait = movieItemDto.ratingAwait,
        ratingAwaitCount = movieItemDto.ratingAwaitCount,
        ratingFilmCritics = movieItemDto.ratingFilmCritics,
        ratingFilmCriticsVoteCount = movieItemDto.ratingRfCriticsVoteCount,
        ratingGoodReview = movieItemDto.ratingGoodReview,
        ratingGoodReviewVoteCount = movieItemDto.ratingGoodReviewVoteCount,
        ratingImdb = movieItemDto.ratingImdb,
        ratingImdbVoteCount = movieItemDto.ratingImdbVoteCount,
        ratingKinopoisk = movieItemDto.ratingKinopoisk,
        ratingKinopoiskVoteCount = movieItemDto.ratingKinopoiskVoteCount,
        ratingMpaa = movieItemDto.ratingMpaa,
        ratingRfCritics = movieItemDto.ratingRfCritics,
        ratingRfCriticsVoteCount = movieItemDto.ratingRfCriticsVoteCount,
        reviewsCount = movieItemDto.reviewsCount,
        serial = movieItemDto.serial,
        shortDescription = movieItemDto.shortDescription,
        shortFilm = movieItemDto.shortFilm,
        slogan = movieItemDto.slogan,
        startYear = movieItemDto.startYear,
        type = movieItemDto.type,
        webUrl = movieItemDto.webUrl,
        year = movieItemDto.year
    )


    // map Film
    private fun mapFilmDtoToFilmEntity(filmDto: FilmDto) = Film(
        countries = mapListCountryDtoToListCountryEntity(filmDto.countries),
        description = filmDto.description,
        filmId = filmDto.filmId,
        filmLength = filmDto.filmLength,
        genres = mapListGenreDtoToListGenreEntity(filmDto.genres),
        nameEn = filmDto.nameEn,
        nameRu = filmDto.nameRu,
        posterUrl = filmDto.posterUrl,
        posterUrlPreview = filmDto.posterUrlPreview,
        rating = filmDto.rating,
        ratingVoteCount = filmDto.ratingVoteCount,
        type = filmDto.type,
        year = filmDto.year
    )
    private fun mapListFilmDtoToListFilmEntity(list: List<FilmDto>) = list.map {
        mapFilmDtoToFilmEntity(it)
    }

    // map Country
    private fun mapCountryDtoToCountryEntity(countryDto: CountryDto) = Country(
        country = countryDto.country
    )
    private fun mapListCountryDtoToListCountryEntity(list: List<CountryDto>) = list.map {
        mapCountryDtoToCountryEntity(it)
    }

    //map Genre
    private fun mapGenreDtoToGenreEntity(genreDto: GenreDto) = Genre(
        genre = genreDto.genre
    )
    private fun mapListGenreDtoToListGenreEntity(list: List<GenreDto>) = list.map {
        mapGenreDtoToGenreEntity(it)
    }



}