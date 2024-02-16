package com.jcdesign.mymoviewatcher.di

import com.jcdesign.mymoviewatcher.data.MovieRepositoryImpl
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSource
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSourceImpl
import com.jcdesign.mymoviewatcher.domain.MovieRepository
import dagger.Binds
import dagger.Module

@Module
interface MovieModule {

    @Binds
    fun bindMovieRepository(impl: MovieRepositoryImpl): MovieRepository

    @Binds
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource


}