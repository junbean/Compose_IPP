package com.example.compose_ipp.api_project.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apikey : String,
        @Query("q") city : String
    ) : Response<WeatherModel>
}
//https://api.weatherapi.com/v1/current.json?key=2139e4efb6c44d2eb0050701240509&q=London&aqi=no