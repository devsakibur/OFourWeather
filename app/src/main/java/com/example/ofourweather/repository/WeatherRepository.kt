package com.example.ofourweather.repository

import com.example.ofourweather.model.WeatherModel
import com.example.ofourweather.network.NetworkRetrofit

class WeatherRepository {


    suspend fun getWeatherData() : WeatherModel{
        val endUrl = "weather?q=London,uk&units=imperial&APPID=5e07cce60b7f2c623cf638a9d6b22293"
        return NetworkRetrofit.networkServiceApi.getWeatherApi(endUrl)
    }

}