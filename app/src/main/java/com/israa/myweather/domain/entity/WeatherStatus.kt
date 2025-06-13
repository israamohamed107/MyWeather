package com.israa.myweather.domain.entity

import androidx.annotation.DrawableRes
import com.israa.myweather.R

enum class WeatherCondition(
    val condition: String,
    @DrawableRes val icon: Int
) {

    ClearSky(
        condition = "Clear sky",
        icon = R.drawable.ic_clear_sky
    ),

    MainlyClear(
        condition = "Mainly clear",
        icon = R.drawable.ic_mainly_clear
    ),
    PartlyCloudy(
        condition = "Partly cloudy",
        icon = R.drawable.ic_partly_cloudy
    ),
    Overcast(
        condition = "Overcast",
        icon = R.drawable.ic_overcast
    ),
    Foggy(
        condition = "Foggy",
        icon = R.drawable.ic_foggy
    ),
    DepositingRimeFog(
        condition = "Depositing rime fog",
        icon = R.drawable.ic_depositing_rime_fog
    ),
    LightDrizzle(
        condition = "Light drizzle",
        icon = R.drawable.ic_drizzle_light
    ),
    ModerateDrizzle(
        condition = "Moderate drizzle",
        icon = R.drawable.ic_drizzle_moderate
    ),

    DenseDrizzle(
        condition = "Dense intensity drizzle",
        icon = R.drawable.ic_drizzle_intensity
    ),
    LightFreezingDrizzle(
        condition = "Slight freezing drizzle",
        icon = R.drawable.ic_freezing_drizzle_light
    ),

    DenseFreezingDrizzle(
        condition = "Dense freezing drizzle",
        icon = R.drawable.ic_freezing_drizzle_intensity
    ),

    SlightRain(
        condition = "Slight rain",
        icon = R.drawable.ic_rain_slight
    ),
    ModerateRain(
        condition = "Rainy",
        icon = R.drawable.ic_rain_moderate
    ),
    HeavyRain(
        condition = "Heavy rain",
        icon = R.drawable.ic_rain_intensity
    ),
    HeavyFreezingRain(
        condition = "Heavy freezing rain",
        icon = R.drawable.ic_heavy_freezing_rain
    ),
    SlightSnowFall(
        condition = "Slight snow fall",
        icon = R.drawable.ic_snow_fall_light
    ),
    ModerateSnowFall(
        condition = "Moderate snow fall",
        icon = R.drawable.ic_snow_fall_moderate
    ),
    HeavySnowFall(
        condition = "Heavy snow fall",
        icon = R.drawable.ic_heavy_snow_fall
    ),
    SnowGrains(
        condition = "Snow grains",
        icon = R.drawable.ic_snow_grains
    ),
    SlightRainShowers(
        condition = "Slight rain showers",
        icon = R.drawable.ic_rain_slight
    ),
    ModerateRainShowers(
        condition = "Moderate rain showers",
        icon = R.drawable.ic_rain_shower_moderate
    ),
    ViolentRainShowers(
        condition = "Violent rain showers",
        icon = R.drawable.ic_violent_rain_showers
    ),
    SlightSnowShowers(
        condition = "Light snow showers",
        icon = R.drawable.ic_snow_shower_slight
    ),
    HeavySnowShowers(
        condition = "Heavy snow showers",
        icon = R.drawable.ic_snow_shower_heavy
    ),
    ModerateThunderstorm(
        condition = "Moderate thunderstorm",
        icon = R.drawable.ic_thunder_moderate
    ),
    SlightHailThunderstorm(
        condition = "Thunderstorm with slight hail",
        icon = R.drawable.ic_slight_hail_thunder_storm
    ),
    HeavyHailThunderstorm(
        condition = "Thunderstorm with heavy hail",
        icon = R.drawable.ic_thunder_strom_with_heavy_hail
    );

    companion object {
        fun fromWMO(code: Int): WeatherCondition {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}