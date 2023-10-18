package com.example.ofourweather.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ofourweather.R
import com.example.ofourweather.model.ForecastModel

class ForecastAdapter(private val forecasts: List<ForecastModel.ForeCastList>) :
    RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    // Define ViewHolder and methods for binding data here

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forecast_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to ViewHolder
        val forecast = forecasts[position]

        holder.temp.text = forecast.main.tempMax.toString() + " / " + forecast.main.tempMin.toString()
        holder.des.text = forecast.weather[0].main
    }

    override fun getItemCount(): Int {
        // Return the number of contacts in the list
        return forecasts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define UI elements inside the ViewHolder
    val temp: TextView = itemView.findViewById(R.id.row_max_min_tv)
    val des: TextView = itemView.findViewById(R.id.row_condition_tv
        )



    }
}