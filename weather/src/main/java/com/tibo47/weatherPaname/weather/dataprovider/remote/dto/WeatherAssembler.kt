package com.tibo47.weatherPaname.weather.dataprovider.remote.dto

import com.tibo47.weatherPaname.weather.entity.HourlyWeather
import com.tibo47.weatherPaname.weather.entity.HourlyWeatherEntity
import kotlinx.datetime.Instant
import javax.inject.Inject

internal class WeatherAssembler
    @Inject
    constructor() {
        fun createHourlyWeather(dto: OneCall200ResponseDto?): HourlyWeather {
            return if (dto != null) {
                val currentHourlyWeather = dto.hourly!!.first()
                HourlyWeatherEntity(
                    temperature = currentHourlyWeather.temp!!,
                    timestamp = Instant.fromEpochMilliseconds(currentHourlyWeather.dt!!.toLong()),
                    windSpeed = currentHourlyWeather.windSpeed!!,
                    windDirection = currentHourlyWeather.windDeg!!,
                )
            } else {
                throw Exception("Null body from HTTP response")
            }
        }
    }
