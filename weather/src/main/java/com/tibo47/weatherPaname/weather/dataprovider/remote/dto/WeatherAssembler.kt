package com.tibo47.weatherPaname.weather.dataprovider.remote.dto

import com.tibo47.weatherPaname.weather.entity.HourlyWeather
import com.tibo47.weatherPaname.weather.entity.HourlyWeatherEntity
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import javax.inject.Inject

internal class WeatherAssembler
    @Inject
    constructor() {
        fun createHourlies(dto: OneCall200ResponseDto?): List<HourlyWeather> {
            return if (dto != null) {
                val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
                dto.hourly!!
                    .filter {
                        val localDateTime = Instant.fromEpochSeconds(it.dt!!.toLong()).toLocalDateTime(TimeZone.currentSystemDefault())
                        localDateTime.date == today
                    }
                    .map {
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
