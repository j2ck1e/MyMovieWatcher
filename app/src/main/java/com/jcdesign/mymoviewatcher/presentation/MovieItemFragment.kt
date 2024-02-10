package com.jcdesign.mymoviewatcher.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jcdesign.mymoviewatcher.databinding.FragmentMovieItemBinding
import com.jcdesign.mymoviewatcher.domain.Country
import com.jcdesign.mymoviewatcher.domain.Genre
import com.jcdesign.mymoviewatcher.domain.MovieItem


class MovieItemFragment : Fragment() {

    private lateinit var viewModel: MovieItemViewModel
    private lateinit var binding: FragmentMovieItemBinding
    private val args by navArgs<MovieItemFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MovieItemViewModel::class.java]
        viewModel.getMovieItem(args.movieId)
        viewModel.data.observe(viewLifecycleOwner, Observer { it ->
            bindUI(binding, it)
        })

        binding.btnPlayMovie.setOnClickListener {
            TODO()
        }


    }

    private fun bindUI(binding: FragmentMovieItemBinding,it: MovieItem) {
        with(binding) {
            Glide.with(this@MovieItemFragment).load(it.posterUrl).into(ivPoster)
            tvRuName.text = it.nameRu
            tvRating.text = it.rating
            tvEnName.text = it.nameEn
            tvYearAndGenre.text = "${it.year}, ${listGenreToString(it.genres)}"
            tvCountry.text = "${listCountryToString(it.countries)},"
            tvLength.text = "${it.filmLength} мин"
            tvDescription.text = it.description
        }
    }

    private fun listGenreToString(list: List<Genre>): String {
        val listOfString = mutableListOf<String>()
        for (i in list) {
            i.genre?.let { listOfString.add(it) }
        }
        return listOfString.joinToString()
    }

    private fun listCountryToString(list: List<Country>): String {
        val listOfString = mutableListOf<String>()
        for (i in list) {
            i.country?.let { listOfString.add(it) }
        }
        return listOfString.joinToString()
    }


}