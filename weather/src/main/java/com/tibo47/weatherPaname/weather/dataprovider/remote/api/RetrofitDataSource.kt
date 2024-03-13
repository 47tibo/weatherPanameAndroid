package com.tibo47.weatherPaname.weather.dataprovider.remote.api

import com.tibo47.weatherPaname.weather.BuildConfig
import com.tibo47.weatherPaname.weather.dataprovider.remote.WeatherRemoteDataSource
import com.tibo47.weatherPaname.weather.dataprovider.remote.dto.WeatherAssembler
import com.tibo47.weatherPaname.weather.entity.HourlyWeather
import javax.inject.Inject

internal class RetrofitDataSource
    @Inject
    constructor(
        private val api: WeatherApi,
        private val weatherAssembler: WeatherAssembler,
    ) : WeatherRemoteDataSource {
        override suspend fun fetchHourlies(): Result<List<HourlyWeather>> {
            return runCatching {
                // Paris GPS coordinates
                val dto =
                    api.oneCall(
                        "48.861742",
                        "2.332804",
                        BuildConfig.OPEN_WEATHER_APP_ID,
                        "metric",
                    )
                weatherAssembler.createHourlies(dto.body())
            }
        }
    }
