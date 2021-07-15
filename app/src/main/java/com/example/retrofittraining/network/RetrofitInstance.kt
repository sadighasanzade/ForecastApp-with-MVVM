package com.example.retrofittraining.network

import com.example.retrofittraining.utills.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val api : wheaterApi by lazy{
        retrofit.create(wheaterApi::class.java)
    }
}