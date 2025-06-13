package com.israa.myweather.ui.weather

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.israa.myweather.R
import com.israa.myweather.domain.entity.DailyForecast
import com.israa.myweather.domain.entity.DayTime
import com.israa.myweather.ui.theme.UrbanistFontFamily
import com.israa.myweather.ui.theme.WeatherThemeProvider
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherDayItem(
    day: DailyForecast,
    modifier: Modifier = Modifier,
    dayTime: DayTime,
){
    Row (
        modifier = modifier.fillMaxWidth().padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = day.time.format(DateTimeFormatter.ofPattern("EEEE", Locale.getDefault())),
            fontFamily = UrbanistFontFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = WeatherThemeProvider.getTheme(dayTime).bodyColor,
        )

        Image(
            painter = painterResource(day.weatherCondition.icon),
            contentDescription = "Weather Icon",
            modifier = Modifier.size(32.dp)

        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_up),
                contentDescription = "Weather Icon",
                modifier = Modifier.size(12.dp)
            )
            Text(
                text = "${day.temperatureMax} ${day.temperatureUnit}",
                fontFamily = UrbanistFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = WeatherThemeProvider.getTheme(dayTime).headersColor,
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .width(1.dp)
                    .height(12.dp)
                    .background( WeatherThemeProvider.getTheme(dayTime).headersColor,)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Weather Icon",
                modifier = Modifier.size(12.dp)
            )
            Text(
                text = "${day.temperatureMin} ${day.temperatureUnit}",
                fontFamily = UrbanistFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = WeatherThemeProvider.getTheme(dayTime).headersColor,
            )
        }
    }
}