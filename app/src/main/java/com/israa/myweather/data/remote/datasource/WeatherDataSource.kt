package com.israa.myweather.data.remote.datasource

import com.israa.myweather.data.remote.dto.WeatherDto

interface WeatherDataSource {
    suspend fun getWeather(
        latitude: Double,
        longitude: Double
    ): WeatherDto
}