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
import kotlinx.coroutines.launch

class SearchMovieViewModel(
) : ViewModel() {

    val repository = MovieRepositoryImpl()

    private val getMovieListUseCase = GetMovieListUseCase(repository)



    private var _searchData = MutableLiveData<SearchMovies>()
    val searchData: LiveData<SearchMovies>
        get() = _searchData



    fun getMovieList(keyword: String, page: String) = viewModelScope.launch {
        _searchData.value = getMovieListUseCase.invoke(keyword, page)
    }

}