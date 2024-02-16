package com.jcdesign.mymoviewatcher.di

import androidx.lifecycle.ViewModel
import com.jcdesign.mymoviewatcher.presentation.MovieItemViewModel
import com.jcdesign.mymoviewatcher.presentation.SearchMovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieItemViewModel::class)
    fun bindMovieItemViewModel(viewModel: MovieItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchMovieViewModel::class)
    fun bindSearchMovieViewModel(viewModel: SearchMovieViewModel): ViewModel
}