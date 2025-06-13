package com.israa.myweather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyForecastUnitsDto(
    @SerialName("temperature_2m_max") val temperatureMax: String,
    @SerialName("temperature_2m_min") val temperatureMin: String,
    @SerialName("time") val time: String,
    @SerialName("weathercode") val weatherCode: String
)