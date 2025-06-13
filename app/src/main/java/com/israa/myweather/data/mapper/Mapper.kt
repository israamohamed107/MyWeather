package com.israa.myweather.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.israa.myweather.data.remote.dto.WeatherDto
import com.israa.myweather.domain.entity.CurrentForecast
import com.israa.myweather.domain.entity.DailyForecast
import com.israa.myweather.domain.entity.DayTime
import com.israa.myweather.domain.entity.HourlyForecast
import com.israa.myweather.domain.entity.WeatherCondition
import com.israa.myweather.domain.entity.WeatherForecast
import java.time.LocalDate
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toDomain(cityName:String) =
    WeatherForecast(
        city = cityName,
        current = this.toCurrentForecast(),
        daily = this.toDailyForecastList(),
        hourly = this.toHourlyForecastList()
    )

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toCurrentForecast() =
    CurrentForecast(
        dayTime = DayTime.toDayTime(current.isDay),
        temperature = current.temperature,
        temperatureUnit = currentUnits.temperature,
        feelsLikeTemperature = current.apparentTemperature,
        feelsLikeTemperatureUnit = currentUnits.apparentTemperature,
        rain = current.rain,
        rainUnit = currentUnits.rain,
        humidity = current.relativeHumidity,
        humidityUnit = currentUnits.relativeHumidity,
        pressure = current.precipitation,
        pressureUnit = currentUnits.surfacePressure,
        time = LocalDateTime.parse(current.time),
        uvIndex = current.uvIndex,
        uvIndexUnit = currentUnits.uvIndex,
        weatherCondition = WeatherCondition.fromWMO(current.weatherCode),
        windSpeed = current.windSpeed,
        windSpeedUnit = currentUnits.windSpeed
    )

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toDailyForecastList(): List<DailyForecast> {
    return daily.temperatureMax.indices.map { index ->
        DailyForecast(
            temperatureMax = daily.temperatureMax[index],
            temperatureMin = daily.temperatureMin[index],
            weatherCondition = WeatherCondition.fromWMO(daily.weatherCode[index]),
            time = LocalDate.parse(daily.time[index]),
            temperatureUnit = dailyUnits.temperatureMax
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toHourlyForecastList(): List<HourlyForecast> {
    return hourly.temperature.indices.map { index ->
        HourlyForecast(
            temperature = hourly.temperature[index],
            weatherCondition = WeatherCondition.fromWMO(hourly.weatherCode[index]),
            time = LocalDateTime.parse(hourly.time[index]),
            temperatureUnit = hourlyUnits.temperature
        )
    }
}