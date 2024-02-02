package com.tibo47.weatherPaname.weather.dataprovider.remote

import com.tibo47.weatherPaname.weather.entity.HourlyWeather

internal interface WeatherRemoteDataSource {
    suspend fun fetchHourlyWeather(): Result<HourlyWeather>
}
