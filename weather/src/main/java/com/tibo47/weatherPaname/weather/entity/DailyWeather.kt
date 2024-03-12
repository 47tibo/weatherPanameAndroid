package com.tibo47.weatherPaname.weather.entity

import kotlinx.datetime.Instant

public enum class HourlySegment {
    Day,
    Night,
    Eve,
    Morning,
}

public interface DailyWeather {
    public val timestamp: Instant
    public val hourly: Map<HourlySegment, HourlyWeather>
}
