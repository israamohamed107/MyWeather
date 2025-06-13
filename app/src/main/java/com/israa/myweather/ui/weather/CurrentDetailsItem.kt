package com.israa.myweather.ui.weather

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.israa.myweather.ui.theme.UrbanistFontFamily

@Composable
fun CurrentDetailsItem(
    cardBackground: Color,
    borderColor: Color,
    @DrawableRes icon: Int,
    title: String,
    value: String,
    titleColor: Color,
    valueColor: Color
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .width(108.dp)
            .background(cardBackground)
            .border(1.dp, borderColor)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp).fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Weather Icon",
                modifier = Modifier.padding(bottom = 8.dp).size(32.dp),
                tint = Color.Unspecified
            )

            Text(
                text = value,
                fontFamily = UrbanistFontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = title,
                fontFamily = UrbanistFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
            )
        }

    }
}