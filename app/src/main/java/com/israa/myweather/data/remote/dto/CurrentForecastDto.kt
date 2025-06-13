package com.israa.myweather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentForecastDto(
    @SerialName("apparent_temperature") val apparentTemperature: Double,
    @SerialName("interval") val interval: Int,
    @SerialName("is_day") val isDay: Int,
    @SerialName("precipitation") val precipitation: Double,
    @SerialName("rain") val rain: Double,
    @SerialName("relative_humidity_2m") val relativeHumidity: Int,
    @SerialName("surface_pressure") val surfacePressure: Double,
    @SerialName("temperature_2m") val temperature: Double,
    @SerialName("time") val time: String,
    @SerialName("uv_index") val uvIndex: Double,
    @SerialName("weathercode") val weatherCode: Int,
    @SerialName("wind_speed_10m") val windSpeed: Double
)