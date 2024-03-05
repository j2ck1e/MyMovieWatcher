package com.jcdesign.mymoviewatcher.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jcdesign.mymoviewatcher.data.MovieRepositoryImpl
import com.jcdesign.mymoviewatcher.domain.GetMovieItemUseCase
import com.jcdesign.mymoviewatcher.domain.GetMovieListUseCase
import com.jcdesign.mymoviewatcher.domain.MovieItem
import com.jcdesign.mymoviewatcher.domain.SearchMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchMovieViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {


    private var _searchData = MutableSharedFlow<SearchMovies>()
    val searchData: Flow<SearchMovies>
        get() = _searchData


    fun getMovieList(keyword: String, page: String) = viewModelScope.launch {
        _searchData.emit(getMovieListUseCase.invoke(keyword, page))
    }

}