package com.israa.myweather.data.repository

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.os.Build
import androidx.annotation.RequiresApi
import com.israa.myweather.data.LocationDataSource
import com.israa.myweather.data.mapper.toDomain
import com.israa.myweather.data.remote.datasource.WeatherDataSource
import com.israa.myweather.domain.entity.WeatherForecast
import com.israa.myweather.domain.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.Locale

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource,
    private val locationDataSource: LocationDataSource,
    private val context: Context
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeather(latitude: Double, longitude: Double): Flow<WeatherForecast> =
        flow {
            try {
                val response = weatherDataSource.getWeather(latitude, longitude)
                val cityName = getCityName(latitude, longitude)
                emit(
                    response.toDomain(
                        cityName = cityName
                    )
                )
            } catch (e: Exception) {
                throw e
            }
        }.flowOn(Dispatchers.IO)

    override suspend fun getLastKnownLocation(): Flow<Location> = flow {
        try {
            val location = locationDataSource.getLastKnownLocation()
            if (location != null) {
                emit(location)
            } else {
                throw Exception("Location not found")
            }
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getCityName(latitude: Double, longitude: Double): String {
        return try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            addresses?.firstOrNull()?.locality ?: "Unknown"
        } catch (e: Exception) {
            e.printStackTrace()
            "Unknown"
        }
    }

}