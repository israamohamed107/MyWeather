package com.israa.myweather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentForecastUnitsDto(
    @SerialName("apparent_temperature") val apparentTemperature: String,
    @SerialName("interval") val interval: String,
    @SerialName("is_day") val isDay: String,
    @SerialName("precipitation") val precipitation: String,
    @SerialName("rain") val rain: String,
    @SerialName("relative_humidity_2m") val relativeHumidity: String,
    @SerialName("surface_pressure") val surfacePressure: String,
    @SerialName("temperature_2m") val temperature: String,
    @SerialName("time") val time: String,
    @SerialName("uv_index") val uvIndex: String,
    @SerialName("weathercode") val weatherCode: String,
    @SerialName("wind_speed_10m") val windSpeed: String
)