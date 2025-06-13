package com.israa.myweather.domain.repository

import android.location.Location
import com.israa.myweather.domain.entity.WeatherForecast
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(
        latitude: Double,
        longitude: Double
    ): Flow<WeatherForecast>

    suspend fun getLastKnownLocation(): Flow<Location>

}