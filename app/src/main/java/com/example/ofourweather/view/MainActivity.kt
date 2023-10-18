package com.example.ofourweather.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.ofourweather.adapter.ForecastAdapter
import com.example.ofourweather.databinding.ActivityMainBinding
import com.example.ofourweather.model.ForecastModel
import com.example.ofourweather.viewmodel.WeatherViewModel
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel : WeatherViewModel
    private lateinit var adapter: ForecastAdapter
    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)



            viewModel.weatherData.observe(this , Observer {data ->

                binding.temp.text = data.main.temp.toString()
                binding.min.text = data.main.temp_min.roundToInt().toString()+"\u00B0C / "
                binding.max.text = data.main.temp_max.roundToInt().toString()+"\u00B0C    "
                binding.feelsLike.text = data.main.feels_like.roundToInt().toString()+"\u00B0C"


                binding.main.text = data.weather[0].main
                binding.wind.text = data.main.pressure.toString()
                binding.humidity.text = data.main.humidity.toString()
                binding.location.text = data.name

                val weatherIcon = data.weather[0].icon
                Glide.with(applicationContext)
                    .load("https://openweathermap.org/img/w/$weatherIcon.png")
                    .into(binding.icon)
            })


        viewModel.myForecastData.observe(this) {

            adapter = ForecastAdapter(it.list)

            binding.recyclerView.adapter = adapter

        }







    }
}