package com.tibo47.weatherPaname.weather.entity

import kotlinx.datetime.Instant

internal class DailyWeatherEntity(
    override val timestamp: Instant,
    override val hourly: Map<HourlySegment, HourlyWeather>,
) : DailyWeather
