package com.israa.myweather.data.remote.datasource

import com.israa.myweather.data.remote.dto.WeatherDto
import com.israa.myweather.data.utils.WEATHER_BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class WeatherDataSourceImpl(
    private val client: HttpClient
) : WeatherDataSource {
    override suspend fun getWeather(
        latitude: Double,
        longitude: Double
    ): WeatherDto =
        client.get {
            url(WEATHER_BASE_URL)
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter("timezone", "auto")
            parameter("forecast_days", 7)
            parameter("hourly", "temperature_2m,weathercode")
            parameter("daily", "weathercode,temperature_2m_max,temperature_2m_min")
            parameter(
                "current",
                "temperature_2m,apparent_temperature,weathercode,wind_speed_10m,relative_humidity_2m,precipitation,uv_index,is_day,rain,surface_pressure"
            )
        }.body()

}