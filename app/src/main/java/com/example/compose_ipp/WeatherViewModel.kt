package com.example.compose_ipp

import android.util.Log
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {

    fun getData(city : String){
        Log.d("city name", city)
    }
}