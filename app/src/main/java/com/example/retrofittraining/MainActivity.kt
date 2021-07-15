package com.example.retrofittraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofittraining.repository.Repository
import com.example.retrofittraining.utills.Constants.Companion.API_KEY
import com.example.retrofittraining.viewModel.MainViewModel
import com.example.retrofittraining.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel :MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cityName=findViewById(R.id.cityName) as EditText
        val confirmBTN: Button =findViewById(R.id.getForecast)
        val lastUpdate:TextView=findViewById(R.id.lastUpdate)
        val degree:TextView=findViewById(R.id.degree)
        val condition:TextView=findViewById(R.id.condition)

        val repository= Repository()
        val mainViewFactory= MainViewModelFactory(repository)
        mainViewModel= ViewModelProvider(this,mainViewFactory).get(MainViewModel::class.java)


        confirmBTN.setOnClickListener{
            val city=cityName.text.toString()
            mainViewModel.getForecast(API_KEY,city)
            mainViewModel.mResponse.observe(this, Observer {
                response->
                if(response.isSuccessful) {
                    degree.text = response.body()?.current?.tempC.toString()+" C"
                    lastUpdate.text = response.body()?.current?.lastUpdated.toString()
                    condition.text = response.body()?.current?.condition?.text.toString()
                    findViewById<TextView>(R.id.updated).visibility= View.VISIBLE
                }
                else{
                    Log.d("error","cant get forecast")
                }

            })

        }
    }


}