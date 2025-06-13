package com.israa.myweather.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.israa.myweather.R
import com.israa.myweather.domain.entity.WeatherForecast
import com.israa.myweather.ui.theme.UrbanistFontFamily
import com.israa.myweather.ui.theme.WeatherThemeProvider

@Composable
fun CurrentForecastHorizontalComponent(
    weatherData: WeatherForecast,
    collapseProgress: Float
) {
   Row(
         modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 12.dp),
         horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = Alignment.CenterVertically
   ) {
       Image(
           painter = painterResource(weatherData.current.weatherCondition.icon),
           contentDescription = "Weather Image",
           modifier = Modifier
               .padding(vertical = 12.dp)
               .size(124.dp, 112.dp)
       )

       Text(
           text = "${weatherData.current.temperature} ${weatherData.current.temperatureUnit}",
           fontFamily = UrbanistFontFamily,
           fontSize = 64.sp,
           fontWeight = FontWeight.SemiBold
       )
       Text(
           text = weatherData.current.weatherCondition.condition,
           fontFamily = UrbanistFontFamily,
           fontSize = 16.sp,
           fontWeight = FontWeight.Medium,
           color = WeatherThemeProvider.getTheme(weatherData.current.dayTime).bodyColor
       )

       Row(
           horizontalArrangement = Arrangement.spacedBy(1.dp),
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier
               .padding(bottom = 24.dp, top = 12.dp)
               .clip(RoundedCornerShape(100.dp))
               .background(Color(0xFF06041414))
               .padding(vertical = 8.dp, horizontal = 24.dp)
       ) {
           Icon(
               painter = painterResource(id = R.drawable.ic_arrow_up),
               contentDescription = "Weather Icon",
               modifier = Modifier.size(12.dp)
           )
           Text(
               text = "32°C",
               fontFamily = UrbanistFontFamily,
               fontSize = 16.sp,
               fontWeight = FontWeight.Medium,
               color = WeatherThemeProvider.getTheme(weatherData.current.dayTime).bodyColor
           )

           Spacer(
               modifier = Modifier
                   .width(1.dp)
                   .background(Color.Blue)
           )

           Icon(
               painter = painterResource(id = R.drawable.ic_arrow_down),
               contentDescription = "Weather Icon",
               modifier = Modifier.size(12.dp)
           )
           Text(
               text = "20°C",
               fontFamily = UrbanistFontFamily,
               fontSize = 16.sp,
               fontWeight = FontWeight.Medium,
               color = WeatherThemeProvider.getTheme(weatherData.current.dayTime).bodyColor
           )
       }
   }
}