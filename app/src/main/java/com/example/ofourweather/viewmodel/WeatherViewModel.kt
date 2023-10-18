package com.example.ofourweather.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ofourweather.model.ForecastModel
import com.example.ofourweather.model.WeatherModel
import com.example.ofourweather.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    val weatherRepository  = WeatherRepository()
    val weatherData = MutableLiveData<WeatherModel>()
    var myForecastData:MutableLiveData<ForecastModel> = MutableLiveData()


init{
    viewModelScope.launch {
        weatherData.value = weatherRepository.getWeatherData()
        myForecastData.value = weatherRepository.getForecastData()
    }
}




}