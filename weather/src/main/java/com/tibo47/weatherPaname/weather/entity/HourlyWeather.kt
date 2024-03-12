package com.tibo47.weatherPaname.weather.entity

import kotlinx.datetime.Instant

public interface HourlyWeather {
    public val timestamp: Instant
    public val temperature: Float
    public val windSpeed: Float
    public val windDirection: Float
}
