package com.israa.myweather.domain.entity

data class WeatherForecast (
    val city:String,
    val current: CurrentForecast,
    val daily: List<DailyForecast>,
    val hourly: List<HourlyForecast>,
)