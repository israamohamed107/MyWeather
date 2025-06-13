package com.israa.myweather.ui.weather

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.israa.myweather.R
import com.israa.myweather.domain.entity.DayTime
import com.israa.myweather.domain.entity.WeatherForecast
import com.israa.myweather.ui.theme.UrbanistFontFamily
import com.israa.myweather.ui.theme.WeatherThemeProvider
import com.israa.myweather.ui.utils.animateAlignmentAsState
import com.israa.myweather.ui.utils.shadow

@Composable
fun CurrentForecastCollapsable(
    weatherData: WeatherForecast,
    modifier: Modifier = Modifier,
    columnScrollState: ScrollState
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val animatedDp by animateDpAsState(
            targetValue = if (columnScrollState.canScrollBackward) 200.dp else (200 + 12 + 143).dp,
            label = "current weather height",
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessVeryLow
            )
        )
        val animatedImageHeight by animateDpAsState(
            targetValue = if (columnScrollState.canScrollBackward) 112.dp else 200.dp,
            label = "animate image height"
        )
        val animatedImageWidth by animateDpAsState(
            targetValue = if (columnScrollState.canScrollBackward) 124.dp else 227.dp,
            label = "animate image width"
        )
        val imageAlignment by animateAlignmentAsState(if (columnScrollState.canScrollBackward) Alignment.CenterStart else Alignment.TopCenter)
        val temperatureAlignment by animateAlignmentAsState(if (columnScrollState.canScrollBackward) Alignment.CenterEnd else Alignment.BottomCenter)

        Box(
            Modifier
                .fillMaxWidth()
                .height(animatedDp)
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                Modifier
                    .height(animatedImageHeight)
                    .width(animatedImageWidth)
                    .align(imageAlignment)
                    .shadow(
                        color = if (weatherData.current.dayTime == DayTime.Daylight) Color(
                            0x33FFC701
                        ) else Color(0x337E2FFF),
                        shape = CircleShape,
                        blur = 150.dp,

                        )
            ) {
                Image(
                    painter = painterResource(weatherData.current.weatherCondition.icon),
                    contentDescription = null,
                    modifier = Modifier.zIndex(1f)
                )
            }

            Box(
                Modifier
                    .padding(top = 12.dp)
                    .wrapContentSize()
                    .align(temperatureAlignment),
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = "${weatherData.current.temperature} ${weatherData.current.temperatureUnit}",
                        fontFamily = UrbanistFontFamily,
                        fontSize = 64.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = WeatherThemeProvider.getTheme(weatherData.current.dayTime).headersColor
                    )
                    Text(
                        text =  weatherData.current.weatherCondition.condition,
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

                        Box(
                            modifier = Modifier
                                .padding(horizontal = 1.dp)
                                .width(1.dp)
                                .height(12.dp)
                                .background( WeatherThemeProvider.getTheme(weatherData.current.dayTime).bodyColor)
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


        }

//

//
    }
}