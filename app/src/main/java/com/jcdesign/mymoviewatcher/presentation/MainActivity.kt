package com.jcdesign.mymoviewatcher.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jcdesign.mymoviewatcher.R
import com.jcdesign.mymoviewatcher.data.MovieRepositoryImpl
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSourceImpl
import com.jcdesign.mymoviewatcher.data.mapper.Mapper
import com.jcdesign.mymoviewatcher.data.network.ApiFactory
import com.jcdesign.mymoviewatcher.databinding.ActivityMainBinding
import com.jcdesign.mymoviewatcher.databinding.ItemMovieBinding
import com.jcdesign.mymoviewatcher.domain.GetMovieItemUseCase
import com.jcdesign.mymoviewatcher.domain.GetMovieListUseCase
import com.jcdesign.mymoviewatcher.presentation.adapter.MovieSearchAdapter
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var adapter: MovieSearchAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val viewModelFactory = MyViewModelFactory()
//        viewModel = ViewModelProvider(this, viewModelFactory)[MyViewModel::class.java]
//        adapter = MovieSearchAdapter()
//        binding.rvActivity.adapter = adapter
//
//        viewModel.getMovieItem("301")
//        viewModel.getMovieList("джеки", "2")
//
//        viewModel.data.observe(this, Observer {
//
//            Log.d("MyTAG", "data: $it")
//        })
//
//        viewModel.searchData.observe(this, Observer {
//            adapter.submitList(it.films)
//            Log.d("MyTAG", "searchData: $it")
//        })

    }
}