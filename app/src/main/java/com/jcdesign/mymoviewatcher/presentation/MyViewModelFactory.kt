package com.jcdesign.mymoviewatcher.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jcdesign.mymoviewatcher.domain.GetMovieItemUseCase
import com.jcdesign.mymoviewatcher.domain.GetMovieListUseCase


class MyViewModelFactory(
//    val getMovieItemUseCase: GetMovieItemUseCase,
//    val getMovieListUseCase: GetMovieListUseCase

) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel() as T
    }

}