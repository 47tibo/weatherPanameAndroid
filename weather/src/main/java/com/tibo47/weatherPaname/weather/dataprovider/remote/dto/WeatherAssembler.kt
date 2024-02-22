package com.tibo47.weatherPaname.weather.dataprovider.remote.dto

import com.tibo47.weatherPaname.weather.entity.HourlyWeather
import com.tibo47.weatherPaname.weather.entity.HourlyWeatherEntity
import javax.inject.Inject

internal class WeatherAssembler
    @Inject
    constructor() {
        fun createHourlyWeather(dto: OneCall200ResponseDto?): HourlyWeather {
            return if (dto != null) {
                HourlyWeatherEntity(
                    temperature = dto.hourly!!.first().temp!!.toFloat(),
                )
            } else {
                throw Exception("Null body from HTTP response")
            }
        }
    }
