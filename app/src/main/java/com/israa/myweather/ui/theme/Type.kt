package com.israa.myweather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.israa.myweather.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val UrbanistFontFamily = FontFamily(
        Font(R.font.urbanist_medium, FontWeight.Medium),
        Font(R.font.urbanist_regular, FontWeight.Normal),
        Font(R.font.urbanist_semi_bold, FontWeight.SemiBold),
        Font(R.font.urbanist_bold, FontWeight.Bold),
    )
