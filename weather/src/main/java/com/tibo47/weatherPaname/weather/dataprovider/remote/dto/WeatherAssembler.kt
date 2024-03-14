package com.tibo47.weatherPaname.weather.dataprovider.remote.dto

import com.tibo47.weatherPaname.weather.entity.HourlyWeather
import com.tibo47.weatherPaname.weather.entity.HourlyWeatherEntity
import kotlinx.datetime.Instant
import javax.inject.Inject

internal class WeatherAssembler
    @Inject
    constructor() {
        fun createHourlies(dto: OneCall200ResponseDto?): List<HourlyWeather> {
            return if (dto != null) {
                dto.hourly!!.map {
                    HourlyWeatherEntity(
                        temperature = it.temp!!,
                        timestamp = Instant.fromEpochSeconds(it.dt!!.toLong()),
                        windSpeed = it.windSpeed!!,
                        windDirection = it.windDeg!!,
                    )
                }
            } else {
                throw Exception("Null body from HTTP response")
            }
        }
    }
