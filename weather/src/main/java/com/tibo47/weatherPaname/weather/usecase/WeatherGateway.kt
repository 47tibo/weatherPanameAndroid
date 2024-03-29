package com.tibo47.weatherPaname.weather.usecase

import com.tibo47.weatherPaname.weather.entity.HourlyWeather
import kotlinx.coroutines.flow.Flow

public interface WeatherGateway {
    public val hourlies: Flow<Result<List<HourlyWeather>>>
}
