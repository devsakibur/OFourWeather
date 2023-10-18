package com.example.ofourweather.network

import com.example.ofourweather.model.ForecastModel
import com.example.ofourweather.model.WeatherModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

 val baseUse = "https://api.openweathermap.org/data/2.5/"

val retrofit = Retrofit.Builder()
    .baseUrl(baseUse)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface NetworkServiceApi{

    @GET
    suspend fun getWeatherApi(@Url endUrl: String):WeatherModel
    @GET
    suspend fun getForecastApi(@Url endUrl: String):ForecastModel
}


object NetworkRetrofit {
        val networkServiceApi : NetworkServiceApi by lazy {
                retrofit.create(NetworkServiceApi::class.java)
        }
    }