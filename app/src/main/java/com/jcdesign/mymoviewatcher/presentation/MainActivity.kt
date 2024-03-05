package com.jcdesign.mymoviewatcher.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jcdesign.mymoviewatcher.data.network.NetworkManager
import com.jcdesign.mymoviewatcher.databinding.ActivityMainBinding
import com.jcdesign.mymoviewatcher.presentation.adapter.MovieSearchAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

}