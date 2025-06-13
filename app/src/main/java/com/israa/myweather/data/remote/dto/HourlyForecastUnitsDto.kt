package com.israa.myweather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyForecastUnitsDto(
    @SerialName("temperature_2m") val temperature: String,
    @SerialName("time") val time: String,
    @SerialName("weathercode") val weatherCode: String
)