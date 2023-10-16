package com.example.ofourweather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ofourweather.R
import com.example.ofourweather.databinding.ActivityMainBinding
import com.example.ofourweather.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel : WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)


       viewModel.weatherData.observe(this , Observer { data ->


           binding.temp.text = data.main.temp.toString()
       })





    }
}