package com.israa.myweather.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    @SerialName("current") val current: CurrentForecastDto,
    @SerialName("current_units") val currentUnits: CurrentForecastUnitsDto,
    @SerialName("daily") val daily: DailyForecastDto,
    @SerialName("daily_units") val dailyUnits: DailyForecastUnitsDto,
    @SerialName("elevation") val elevation: Double,
    @SerialName("generationtime_ms") val generationTimeMs: Double,
    @SerialName("hourly") val hourly: HourlyForecastDto,
    @SerialName("hourly_units") val hourlyUnits: HourlyForecastUnitsDto,
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double,
    @SerialName("timezone") val timezone: String,
    @SerialName("timezone_abbreviation") val timezoneAbbreviation: String,
    @SerialName("utc_offset_seconds") val utcOffsetSeconds: Int
)