package com.jcdesign.mymoviewatcher.data.network

import com.jcdesign.mymoviewatcher.BuildConfig
import com.jcdesign.mymoviewatcher.data.datasource.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://kinopoiskapiunofficial.tech"
    private const val API_KEY = "9668e255-e70e-4199-bf94-3471789abc07"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    chain.proceed(chain.request().newBuilder().also {
                        it.addHeader("X-API-KEY", API_KEY)
                    }.build())
                }.also { client ->
                    if (BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getRetrofitInstance() = retrofit.create(ApiService::class.java)
}