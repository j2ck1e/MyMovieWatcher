package com.jcdesign.mymoviewatcher.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MyViewModelFactory(
//    val getMovieItemUseCase: GetMovieItemUseCase,
//    val getMovieListUseCase: GetMovieListUseCase

) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchMovieViewModel() as T
    }

}