package com.jcdesign.mymoviewatcher.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcdesign.mymoviewatcher.data.MovieRepositoryImpl
import com.jcdesign.mymoviewatcher.domain.GetMovieItemUseCase
import com.jcdesign.mymoviewatcher.domain.MovieItem
import kotlinx.coroutines.launch

class MovieItemViewModel: ViewModel() {

    private val repository = MovieRepositoryImpl()
    private val getMovieItemUseCase = GetMovieItemUseCase(repository)

    private var _data = MutableLiveData<MovieItem>()
    val data: LiveData<MovieItem>
        get() = _data

    fun getMovieItem(movieId: String) = viewModelScope.launch {
        _data.value = getMovieItemUseCase.invoke(movieId)
    }
}