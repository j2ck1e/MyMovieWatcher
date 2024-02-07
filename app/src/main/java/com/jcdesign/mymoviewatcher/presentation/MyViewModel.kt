package com.jcdesign.mymoviewatcher.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcdesign.mymoviewatcher.data.MovieRepositoryImpl
import com.jcdesign.mymoviewatcher.domain.Film
import com.jcdesign.mymoviewatcher.domain.GetMovieItemUseCase
import com.jcdesign.mymoviewatcher.domain.GetMovieListUseCase
import com.jcdesign.mymoviewatcher.domain.MovieItem
import com.jcdesign.mymoviewatcher.domain.SearchMovies
import kotlinx.coroutines.launch

class MyViewModel(
) : ViewModel() {

    val repository = MovieRepositoryImpl()

    private val getMovieItemUseCase = GetMovieItemUseCase(repository)
    private val getMovieListUseCase = GetMovieListUseCase(repository)

    private var _data = MutableLiveData<MovieItem>()
    val data: LiveData<MovieItem>
        get() = _data

    private var _searchData = MutableLiveData<SearchMovies>()
    val searchData: LiveData<SearchMovies>
        get() = _searchData

    fun getMovieItem(movieId: String) = viewModelScope.launch {
        _data.value = getMovieItemUseCase.invoke(movieId)
    }

    fun getMovieList(keyword: String, page: String) = viewModelScope.launch {
        _searchData.value = getMovieListUseCase.invoke(keyword, page)
    }

}