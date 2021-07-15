package com.example.retrofittraining.model


import com.google.gson.annotations.SerializedName

data class CurrentWheather(
        @SerializedName("current")
    val current: Current,
        @SerializedName("location")
    val location: Location
)