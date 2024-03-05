package com.jcdesign.mymoviewatcher.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcdesign.mymoviewatcher.data.MovieRepositoryImpl
import com.jcdesign.mymoviewatcher.domain.GetMovieItemUseCase
import com.jcdesign.mymoviewatcher.domain.MovieItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieItemViewModel @Inject constructor(
    private val getMovieItemUseCase: GetMovieItemUseCase
) :
    ViewModel() {


    private var _data = MutableSharedFlow<MovieItem>()
    val data: Flow<MovieItem>
        get() = _data

    fun getMovieItem(movieId: String) = viewModelScope.launch {
        _data.emit(getMovieItemUseCase.invoke(movieId))
    }
}