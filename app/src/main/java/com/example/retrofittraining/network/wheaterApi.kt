package com.example.retrofittraining.network

import com.example.retrofittraining.model.CurrentWheather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface wheaterApi {
    @GET("current.json")
    suspend fun getForecast(
        @Query("key") key:String,
        @Query("q") city:String
    ):Response<CurrentWheather>
}