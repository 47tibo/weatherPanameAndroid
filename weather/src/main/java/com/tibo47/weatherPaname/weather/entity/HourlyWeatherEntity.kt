package com.tibo47.weatherPaname.weather.entity

internal data class HourlyWeatherEntity(
    override val hour: Any = "TODO",
    override val temperature: Float,
) : HourlyWeather
