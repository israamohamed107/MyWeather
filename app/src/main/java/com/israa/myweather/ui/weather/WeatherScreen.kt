package com.israa.myweather.ui.weather

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.israa.myweather.R
import com.israa.myweather.domain.entity.CurrentForecast
import com.israa.myweather.domain.entity.DailyForecast
import com.israa.myweather.domain.entity.DayTime
import com.israa.myweather.domain.entity.HourlyForecast
import com.israa.myweather.domain.entity.WeatherCondition
import com.israa.myweather.domain.entity.WeatherForecast
import com.israa.myweather.ui.theme.UrbanistFontFamily
import com.israa.myweather.ui.theme.WeatherThemeProvider
import com.israa.myweather.ui.utils.getIcon
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = koinViewModel()
) {
    viewModel.getWeather()
    val state = viewModel.state.collectAsStateWithLifecycle().value

    WeatherContent(
        state = state
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun WeatherContent(
    state: WeatherState
) {
    Log.e("pppedpep", "getWeather: ${state.weatherData}")
    val columnScrollState = rememberScrollState()
    state.weatherData?.let { weatherData ->
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(bottom = 36.dp)
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            WeatherThemeProvider.getTheme(weatherData.current.dayTime).startGradient,
                            WeatherThemeProvider.getTheme(weatherData.current.dayTime).endGradient
                        )
                    )
                )
                .verticalScroll(state = columnScrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "Weather Icon",
                    modifier = Modifier.padding(end = 4.dp),
                    tint = WeatherThemeProvider.getTheme(weatherData.current.dayTime).cityNameColor
                )
                Text(
                    text = weatherData.city,
                    fontFamily = UrbanistFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = WeatherThemeProvider.getTheme(weatherData.current.dayTime).cityNameColor
                )
            }

            CurrentForecastCollapsable(
                weatherData = weatherData,
                columnScrollState = columnScrollState
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CurrentDetailsItem(
                    cardBackground = WeatherThemeProvider.getTheme(weatherData.current.dayTime).mainColor,
                    borderColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor,
                    icon = R.drawable.ic_fast_wind,
                    title = "Wind",
                    value = "${weatherData.current.windSpeed} ${weatherData.current.windSpeedUnit}",
                   dayTime = weatherData.current.dayTime
                )

                CurrentDetailsItem(
                    cardBackground = WeatherThemeProvider.getTheme(weatherData.current.dayTime).mainColor,
                    borderColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor,
                    icon = R.drawable.ic_humidity,
                    title = "Humidity",
                    value = "${weatherData.current.humidity} ${weatherData.current.humidityUnit}",
                    dayTime = weatherData.current.dayTime
                )

                CurrentDetailsItem(
                    cardBackground = WeatherThemeProvider.getTheme(weatherData.current.dayTime).mainColor,
                    borderColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor,
                    icon = R.drawable.ic_rain,
                    title = "Rain",
                    value = "${weatherData.current.rain} ${weatherData.current.rainUnit}",
                    dayTime = weatherData.current.dayTime
                )
            }


            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 6.dp, bottom = 24.dp)
            ) {
                CurrentDetailsItem(
                    cardBackground = WeatherThemeProvider.getTheme(weatherData.current.dayTime).mainColor,
                    borderColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor,
                    icon = R.drawable.ic_fast_wind,
                    title = "UV index",
                    value = "${weatherData.current.uvIndex} ${weatherData.current.uvIndexUnit}",
                    dayTime = weatherData.current.dayTime
                )

                CurrentDetailsItem(
                    cardBackground = WeatherThemeProvider.getTheme(weatherData.current.dayTime).mainColor,
                    borderColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor,
                    icon = R.drawable.ic_humidity,
                    title = "Pressure",
                    value = "${weatherData.current.pressure} ${weatherData.current.pressureUnit}",
                    dayTime = weatherData.current.dayTime
                )

                CurrentDetailsItem(
                    cardBackground = WeatherThemeProvider.getTheme(weatherData.current.dayTime).mainColor,
                    borderColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor,
                    icon = R.drawable.ic_rain,
                    title = "Feels like",
                    value = "${weatherData.current.feelsLikeTemperature} ${weatherData.current.feelsLikeTemperatureUnit}",
                    dayTime = weatherData.current.dayTime
                )
            }

            Text(
                text = "Today",
                fontFamily = UrbanistFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth(),
                color = WeatherThemeProvider.getTheme(weatherData.current.dayTime).titleColor
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(start = 12.dp)
                    .fillMaxWidth()
            ) {

                items(weatherData.hourly) { item ->
                    TodayItem(
                        cardBackground = WeatherThemeProvider.getTheme(weatherData.current.dayTime).mainColor,
                        borderColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor,
                        icon = item.weatherCondition.getIcon(weatherData.current.dayTime),
                        temperature = "${item.temperature} ${item.temperatureUnit}",
                        time = item.time.format(DateTimeFormatter.ofPattern("HH:mm")),
                        temperatureColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).headersColor,
                        timeColor = WeatherThemeProvider.getTheme(weatherData.current.dayTime).bodyColor,
                        dayTime = weatherData.current.dayTime
                    )
                }
            }

            Text(
                text = "Next 7 days",
                fontFamily = UrbanistFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 12.dp, top = 24.dp)
                    .fillMaxWidth(),
                color = WeatherThemeProvider.getTheme(weatherData.current.dayTime).titleColor
            )

            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .border(
                        1.dp,
                        WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor,
                        RoundedCornerShape(24.dp)
                    )
                    .fillMaxWidth()
                    .background(WeatherThemeProvider.getTheme(weatherData.current.dayTime).mainColor)
                    .padding(vertical = 16.dp)
            ) {
                weatherData.daily.forEachIndexed { index, day ->
                    WeatherDayItem(
                        day,
                        modifier = Modifier.padding(12.dp),
                        dayTime = weatherData.current.dayTime
                    )
                    if (index != 6) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(WeatherThemeProvider.getTheme(weatherData.current.dayTime).borderColor)
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun WeatherPreview() {

    WeatherContent(
        state = WeatherState(
            weatherData = WeatherForecast(
                city = "Test City",
                current = CurrentForecast(
                    dayTime = DayTime.Daylight,
                    temperature = 25.0,
                    temperatureUnit = "°C",
                    feelsLikeTemperature = 27.0,
                    feelsLikeTemperatureUnit = "°C",
                    rain = 0.0,
                    rainUnit = "mm",
                    humidity = 60,
                    humidityUnit = "%",
                    pressure = 1015.0,
                    pressureUnit = "hPa",
                    time = LocalDateTime.now(),
                    uvIndex = 5.0,
                    uvIndexUnit = "index",
                    weatherCondition = WeatherCondition.ClearSky,
                    windSpeed = 10.0,
                    windSpeedUnit = "km/h"
                ),
                daily = listOf(
                    DailyForecast(
                        temperatureMax = 30.0,
                        temperatureMin = 20.0,
                        temperatureUnit = "°C",
                        weatherCondition = WeatherCondition.MainlyClear,
                        time = LocalDate.now()
                    ),
                    DailyForecast(
                        temperatureMax = 28.0,
                        temperatureMin = 18.0,
                        temperatureUnit = "°C",
                        weatherCondition = WeatherCondition.HeavyRain,
                        time = LocalDate.now().plusDays(1)
                    )
                ),
                hourly = listOf(
                    HourlyForecast(
                        temperature = 25.0,
                        temperatureUnit = "°C",
                        weatherCondition = WeatherCondition.ClearSky,
                        time = LocalDateTime.now()
                    ),
                    HourlyForecast(
                        temperature = 23.0,
                        temperatureUnit = "°C",
                        weatherCondition = WeatherCondition.HeavyRain,
                        time = LocalDateTime.now().plusHours(1)
                    ),
                    HourlyForecast(
                        temperature = 23.0,
                        temperatureUnit = "°C",
                        weatherCondition = WeatherCondition.HeavyRain,
                        time = LocalDateTime.now().plusHours(1)
                    ),
                    HourlyForecast(
                        temperature = 23.0,
                        temperatureUnit = "°C",
                        weatherCondition = WeatherCondition.HeavyRain,
                        time = LocalDateTime.now().plusHours(1)
                    )
                )
            )
        )
    )
}