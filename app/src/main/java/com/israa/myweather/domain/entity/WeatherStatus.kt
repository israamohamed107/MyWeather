package com.israa.myweather.domain.entity

import androidx.annotation.DrawableRes
import com.israa.myweather.R

enum class WeatherCondition(
    val condition: String,
    @DrawableRes val iconDay: Int,
    @DrawableRes val iconNight: Int,
) {

    ClearSky(
        condition = "Clear sky",
        iconDay = R.drawable.ic_clear_sky,
        iconNight = R.drawable.ic_clear_sky_night,
    ),

    MainlyClear(
        condition = "Mainly clear",
        iconDay = R.drawable.ic_mainly_clear,
        iconNight = R.drawable.ic_mainly_clear_night,
    ),
    PartlyCloudy(
        condition = "Partly cloudy",
        iconDay = R.drawable.ic_partly_cloudy,
        iconNight = R.drawable.ic_partly_cloudy_night,
    ),
    Overcast(
        condition = "Overcast",
        iconDay = R.drawable.ic_overcast,
        iconNight = R.drawable.ic_overcast_night,
    ),
    Foggy(
        condition = "Foggy",
        iconDay = R.drawable.ic_foggy,
        iconNight = R.drawable.ic_foggy_night,
    ),
    DepositingRimeFog(
        condition = "Depositing rime fog",
        iconDay = R.drawable.ic_depositing_rime_fog,
        iconNight = R.drawable.ic_depositing_rime_fog_night,
    ),
    LightDrizzle(
        condition = "Light drizzle",
        iconDay = R.drawable.ic_drizzle_light,
        iconNight = R.drawable.ic_drizzle_light_night,
    ),
    ModerateDrizzle(
        condition = "Moderate drizzle",
        iconDay = R.drawable.ic_drizzle_moderate,
        iconNight = R.drawable.ic_drizzle_moderate_night,
    ),

    DenseDrizzle(
        condition = "Dense intensity drizzle",
        iconDay = R.drawable.ic_drizzle_intensity,
        iconNight = R.drawable.ic_drizzle_intensity_night,
    ),
    LightFreezingDrizzle(
        condition = "Slight freezing drizzle",
        iconDay = R.drawable.ic_freezing_drizzle_light,
        iconNight = R.drawable.ic_freezing_drizzle_light_night,
    ),

    DenseFreezingDrizzle(
        condition = "Dense freezing drizzle",
        iconDay = R.drawable.ic_freezing_drizzle_intensity,
        iconNight = R.drawable.ic_freezing_drizzle_intensity_night,
    ),

    SlightRain(
        condition = "Slight rain",
        iconDay = R.drawable.ic_rain_slight,
        iconNight = R.drawable.ic_rain_slight_night,
    ),
    ModerateRain(
        condition = "Rainy",
        iconDay = R.drawable.ic_rain_moderate,
        iconNight = R.drawable.ic_rain_moderate_night,
    ),
    HeavyRain(
        condition = "Heavy rain",
        iconDay = R.drawable.ic_rain_intensity,
        iconNight = R.drawable.ic_rain_intensity_night,
    ),
    HeavyFreezingRain(
        condition = "Heavy freezing rain",
        iconDay = R.drawable.ic_heavy_freezing_rain,
        iconNight = R.drawable.ic_heavy_freezing_rain,
    ),
    SlightSnowFall(
        condition = "Slight snow fall",
        iconDay = R.drawable.ic_snow_fall_light,
        iconNight = R.drawable.ic_snow_fall_light_night,
    ),
    ModerateSnowFall(
        condition = "Moderate snow fall",
        iconDay = R.drawable.ic_snow_fall_moderate,
        iconNight = R.drawable.ic_snow_fall_moderate_night,
    ),
    HeavySnowFall(
        condition = "Heavy snow fall",
        iconDay = R.drawable.ic_heavy_snow_fall,
        iconNight = R.drawable.ic_heavy_snow_fall,
    ),
    SnowGrains(
        condition = "Snow grains",
        iconDay = R.drawable.ic_snow_grains,
        iconNight = R.drawable.ic_snow_grains_night,
    ),
    SlightRainShowers(
        condition = "Slight rain showers",
        iconDay = R.drawable.ic_rain_slight,
        iconNight = R.drawable.ic_rain_slight_night,
    ),
    ModerateRainShowers(
        condition = "Moderate rain showers",
        iconDay = R.drawable.ic_rain_shower_moderate,
        iconNight = R.drawable.ic_rain_shower_moderate_night,
    ),
    ViolentRainShowers(
        condition = "Violent rain showers",
        iconDay = R.drawable.ic_violent_rain_showers,
        iconNight = R.drawable.ic_violent_rain_showers,
    ),
    SlightSnowShowers(
        condition = "Light snow showers",
        iconDay = R.drawable.ic_snow_shower_slight,
        iconNight = R.drawable.ic_snow_shower_slight_night,
    ),
    HeavySnowShowers(
        condition = "Heavy snow showers",
        iconDay = R.drawable.ic_snow_shower_heavy,
        iconNight = R.drawable.ic_snow_shower_heavy_night,
    ),
    ModerateThunderstorm(
        condition = "Moderate thunderstorm",
        iconDay = R.drawable.ic_thunder_moderate,
        iconNight = R.drawable.ic_thunder_moderate,
    ),
    SlightHailThunderstorm(
        condition = "Thunderstorm with slight hail",
        iconDay = R.drawable.ic_slight_hail_thunder_storm,
        iconNight = R.drawable.ic_slight_hail_thunder_storm,
    ),
    HeavyHailThunderstorm(
        condition = "Thunderstorm with heavy hail",
        iconDay = R.drawable.ic_thunder_strom_with_heavy_hail,
        iconNight = R.drawable.ic_thunder_strom_with_heavy_hail_night,
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