package com.israa.myweather.domain.entity

import java.time.LocalDateTime

data class HourlyForecast(
    val temperature: Double,
    val  temperatureUnit:String,
    val weatherCondition: WeatherCondition,
    val time: LocalDateTime
)
