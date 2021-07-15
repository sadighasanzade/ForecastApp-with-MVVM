package com.example.retrofittraining.repository

import com.example.retrofittraining.model.CurrentWheather
import com.example.retrofittraining.network.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getForecast(key:String,city:String) :Response<CurrentWheather>{
        return RetrofitInstance.api.getForecast(key,city)
    }
}