package com.tibo47.weatherPaname.weather.entity

import kotlinx.datetime.Instant

internal data class HourlyWeatherEntity(
    override val temperature: Float,
    override val timestamp: Instant,
    override val windSpeed: Float,
    override val windDirection: Float,
) : HourlyWeather
