package com.israa.myweather.domain.entity

import java.time.LocalDate

data class DailyForecast(
    val temperatureMax: Double,
    val temperatureMin: Double,
    val temperatureUnit: String,
    val weatherCondition: WeatherCondition,
    val time: LocalDate
)
