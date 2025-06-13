package com.israa.myweather.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.israa.myweather.domain.entity.DayTime
import com.israa.myweather.ui.theme.UrbanistFontFamily
import com.israa.myweather.ui.utils.shadow

@Composable
fun TodayItem(
    cardBackground: Color,
    borderColor: Color,
    icon: Int,
    temperature: String,
    time: String,
    temperatureColor: Color,
    timeColor: Color,
    dayTime: DayTime,
) {
    Box(

    ) {
        Box(
            modifier = Modifier
                .offset(y = 12.dp)
                .clip(RoundedCornerShape(20.dp))
                .size(88.dp, 120.dp)
                .background(cardBackground)
                .border(1.dp, borderColor,RoundedCornerShape(20.dp)),
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = "Weather Icon",
                modifier = Modifier.padding(bottom = 16.dp).size(64.dp,58.dp).shadow(
                    color = if (dayTime == DayTime.Daylight) Color(
                        0x33FFC701
                    ) else Color(0x337E2FFF),
                    shape = CircleShape,
                    blur = 150.dp,

                    )

            )

            Text(
                text = temperature,
                fontFamily = UrbanistFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = temperatureColor,
            )

            Text(
                text = time,
                fontFamily = UrbanistFontFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = timeColor,
            )
        }
    }
}