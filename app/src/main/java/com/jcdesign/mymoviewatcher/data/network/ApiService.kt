package com.jcdesign.mymoviewatcher.data.network


import androidx.lifecycle.LiveData
import com.jcdesign.mymoviewatcher.BuildConfig
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSource
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSourceImpl
import com.jcdesign.mymoviewatcher.data.network.model.MovieItemDto
import com.jcdesign.mymoviewatcher.data.network.model.SearchMoviesDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("/api/v2.1/films/search-by-keyword")
    suspend fun getListMovie(
        @Query("keyword") word: String,
        @Query("page") page: String,
    ): LiveData<SearchMoviesDto>

    @GET("/api/v2.2/films/{id}")
    suspend fun getMovieById(
        @Path("id") movieId: String
    ): LiveData<MovieItemDto>



}