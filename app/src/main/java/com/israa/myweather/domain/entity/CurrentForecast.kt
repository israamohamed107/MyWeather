package com.israa.myweather.domain.entity

import java.time.LocalDateTime

data class CurrentForecast(
    val dayTime: DayTime,
    val temperature: Double,
    val temperatureUnit: String,
    val feelsLikeTemperature: Double,
    val feelsLikeTemperatureUnit: String,
    val rain: Double,
    val rainUnit: String,
    val humidity: Int,
    val humidityUnit: String,
    val pressure: Double,
    val pressureUnit: String,
    val time: LocalDateTime,
    val uvIndex: Double,
    val uvIndexUnit: String,
    val weatherCondition: WeatherCondition,
    val windSpeed: Double,
    val windSpeedUnit: String,
)
