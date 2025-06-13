package com.israa.myweather.ui.utils

import com.israa.myweather.domain.entity.DayTime
import com.israa.myweather.domain.entity.WeatherCondition

fun WeatherCondition.getIcon(dayTime: DayTime): Int {
    return if (dayTime == DayTime.Daylight) this.iconDay else this.iconNight
}