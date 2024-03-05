package com.jcdesign.mymoviewatcher.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.jcdesign.mymoviewatcher.databinding.FragmentSearchMovieBinding
import com.jcdesign.mymoviewatcher.domain.Film
import com.jcdesign.mymoviewatcher.presentation.adapter.MovieSearchAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject


class SearchMovieFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: MyViewModelFactory
    private lateinit var viewModel: SearchMovieViewModel
    private lateinit var adapter: MovieSearchAdapter
    private lateinit var binding: FragmentSearchMovieBinding

    private val component by lazy {
        (requireActivity().application as MovieApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this, viewModelFactory)[SearchMovieViewModel::class.java]
        adapter = MovieSearchAdapter()
        binding.rvActivity.adapter = adapter

        binding.etSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(keyword: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(keyword: String?): Boolean {
                keyword?.let { viewModel.getMovieList(it, "1") }
                return true
            }

        })


        lifecycleScope.launch {
            viewModel.searchData.collect {
                adapter.submitList(it.films)
            }
        }

        adapter.onItemClickListener = object : MovieSearchAdapter.OnItemClickListener {
            override fun onMovieItemClick(movieItem: Film) {
                findNavController().navigate(
                    SearchMovieFragmentDirections
                        .actionSearchMovieFragmentToMovieItemFragment(movieItem.filmId.toString())
                )
            }
        }
    }

}