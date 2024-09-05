package com.example.compose_ipp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.weatherapi.com"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
//https://api.weatherapi.com/v1/current.json?key=2139e4efb6c44d2eb0050701240509&q=London&aqi=no