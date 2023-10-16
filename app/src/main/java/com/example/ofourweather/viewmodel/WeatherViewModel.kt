package com.example.ofourweather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ofourweather.model.WeatherModel
import com.example.ofourweather.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    val weatherRepository  = WeatherRepository()
    val weatherData = MutableLiveData<WeatherModel>()


fun fetchData(){
    viewModelScope.launch {
        weatherData.value = weatherRepository.getWeatherData()
    }
}




}