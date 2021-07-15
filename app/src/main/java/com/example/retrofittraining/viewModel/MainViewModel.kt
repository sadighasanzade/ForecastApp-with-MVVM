package com.example.retrofittraining.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittraining.model.CurrentWheather
import com.example.retrofittraining.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val mResponse : MutableLiveData<Response<CurrentWheather>> = MutableLiveData()

    fun getForecast(key:String,city:String){
        viewModelScope.launch {
            try {
                val response = repository.getForecast(key, city)

                mResponse.value = response
            }
            catch(e: Exception){
                Log.d("error message",e.toString())
            }
        }
    }


}