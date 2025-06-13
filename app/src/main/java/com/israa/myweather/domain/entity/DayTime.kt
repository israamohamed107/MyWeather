package com.israa.myweather.domain.entity

enum class DayTime {
    Daylight,
    Night;

    companion object {

        fun toDayTime(value: Int): DayTime {
            return when (value) {
                1 -> Daylight
                0 -> Night
                else -> Night
            }
        }
    }
}