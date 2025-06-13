package com.israa.myweather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyForecastDto(
    @SerialName("temperature_2m") val temperature: List<Double>,
    @SerialName("time") val time: List<String>,
    @SerialName("weathercode") val weatherCode: List<Int>
)