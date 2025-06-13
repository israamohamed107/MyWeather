package com.israa.myweather.ui.weather

import com.israa.myweather.domain.entity.WeatherForecast

data class WeatherState (
    val weatherData: WeatherForecast? = null,
)