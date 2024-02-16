package com.jcdesign.mymoviewatcher.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.jcdesign.mymoviewatcher.R
import com.jcdesign.mymoviewatcher.data.MovieListRepositoryImpl
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSource
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSourceImpl
import com.jcdesign.mymoviewatcher.data.mapper.Mapper
import com.jcdesign.mymoviewatcher.data.network.ApiService
import com.jcdesign.mymoviewatcher.domain.GetMovieListUseCase
import com.jcdesign.mymoviewatcher.domain.MovieListRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}