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
        countries = mapListCountryDtoToListCountryEntity(movieItemDto.countries),
        description = movieItemDto.description,
        filmLength = movieItemDto.filmLength.toString(),
        genres = mapListGenreDtoToListGenreEntity(movieItemDto.genres),
        nameEn = movieItemDto.nameEn,
        nameRu = movieItemDto.nameRu,
        posterUrl = movieItemDto.posterUrl,
        posterUrlPreview = movieItemDto.posterUrlPreview,
        type = movieItemDto.type,
        year = movieItemDto.year.toString(),
        filmId = movieItemDto.kinopoiskId,
        webUrl = toFlicksbarLink(movieItemDto.webUrl),
        rating = movieItemDto.ratingKinopoisk.toString()
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

    private fun toFlicksbarLink(link: String): String {
        return link.replace("www.kinopoisk.ru", "www.sspoisk.ru")
    }


}