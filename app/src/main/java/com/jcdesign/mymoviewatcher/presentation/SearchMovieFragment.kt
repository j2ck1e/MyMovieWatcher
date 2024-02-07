package com.jcdesign.mymoviewatcher.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jcdesign.mymoviewatcher.R
import com.jcdesign.mymoviewatcher.databinding.ActivityMainBinding
import com.jcdesign.mymoviewatcher.databinding.FragmentSearchMovieBinding
import com.jcdesign.mymoviewatcher.presentation.adapter.MovieSearchAdapter


class SearchMovieFragment : Fragment() {

    private lateinit var viewModel: MyViewModel
    private lateinit var adapter: MovieSearchAdapter
    private lateinit var binding: FragmentSearchMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchMovieBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = MyViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[MyViewModel::class.java]
        adapter = MovieSearchAdapter()
        binding.rvActivity.adapter = adapter

        viewModel.getMovieList("джеки", "2")

        viewModel.searchData.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it.films)
            Log.d("MyTAG", "searchData: $it")
        })
    }

}