package com.israa.myweather.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.israa.myweather.domain.entity.DayTime

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

)


data class MyWeatherTheme(
    val mainColor:Color,
    val iconColor:Color,
    val headersColor:Color,
    val bodyColor:Color,
    val borderColor:Color,
    val titleColor:Color,
    val arrowsColor:Color,
    val cityNameColor:Color,
    val startGradient:Color,
    val endGradient:Color,
    val dividerColor:Color,
    val blurColor:Color,
)

private val DayLightColors = MyWeatherTheme(
    mainColor = Color(0xB3FFFFFF),
    iconColor = Color(0xFF87CEFA),
    headersColor = Color(0xDE060414),
    bodyColor = Color(0x99060414),
    borderColor = Color(0x14060414),
    titleColor = Color(0xFF060414),
    arrowsColor = Color(0x99060414),
    cityNameColor = Color(0xFF323232),
    startGradient = Color(0xFF87CEFA),
    endGradient = Color(0xFFFFFFFF),
    dividerColor = Color(0x3D060414),
    blurColor = Color(0xFF00619D)
)

private val NightColors = MyWeatherTheme(
    mainColor = Color(0xB3060414),
    iconColor = Color(0xFF87CEFA),
    headersColor = Color(0xDEFFFFFF),
    bodyColor = Color(0x99FFFFFF),
    borderColor = Color(0x14FFFFFF),
    titleColor = Color(0xFFFFFFFF),
    arrowsColor = Color(0xDEFFFFFF),
    cityNameColor = Color(0xFFFFFFFF),
    startGradient = Color(0xFF060414),
    endGradient = Color(0xFF0D0C19),
    dividerColor = Color(0x3DFFFFFF),
    blurColor = Color(0xFFC0B7FF),
)


object WeatherThemeProvider {
    fun getTheme(dayTime: DayTime): MyWeatherTheme {
        return when (dayTime) {
            DayTime.Daylight -> DayLightColors
            DayTime.Night -> NightColors
        }
    }
}

@Composable
fun MyWeatherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}