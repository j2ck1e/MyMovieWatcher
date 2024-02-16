package com.jcdesign.mymoviewatcher.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
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


        onBackPressed()

        viewModel = ViewModelProvider(this)[MovieItemViewModel::class.java]
        viewModel.getMovieItem(args.movieId)
        viewModel.data.observe(viewLifecycleOwner, Observer { it ->
            bindUI(binding, it)
        })

    }

    private fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigateUp()
        }
    }

    private fun bindUI(binding: FragmentMovieItemBinding, item: MovieItem) {
        with(binding) {
            Glide.with(this@MovieItemFragment).load(item.posterUrl).into(ivPoster)
            tvRuName.text = item.nameRu
            tvRating.text = item.rating
            tvEnName.text = item.nameEn
            tvYearAndGenre.text = "${item.year}, ${listGenreToString(item.genres)}"
            tvCountry.text = "${listCountryToString(item.countries)},"
            tvLength.text = "${item.filmLength} мин"
            tvDescription.text = item.description

            btnPlayMovie.setOnClickListener {
                val chromeIntent = CustomTabsIntent.Builder().build()
                chromeIntent.launchUrl(requireContext(), Uri.parse(item.webUrl))
            }
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