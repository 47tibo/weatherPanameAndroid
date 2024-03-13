package com.tibo47.weatherPaname.weather.usecase

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @return The temperature (Celsius) in downtown Paris at the current hour.
 */
@ViewModelScoped
public class GetCurrentHourTemperatureUseCase
    @Inject
    constructor(
        private val weatherRepository: WeatherGateway,
    ) {
        public operator fun invoke(): Flow<Result<Float>> =
            weatherRepository.hourlies.map { hourlyList ->
                hourlyList.map { it.first().temperature }
            }
    }
