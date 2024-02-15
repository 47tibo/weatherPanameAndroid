package com.tibo47.weatherPaname.weather.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
// TODO @ViewModelScoped when view model ready

/**
 * @return The temperature (Celsius) in downtown Paris at the current hour.
 */
public class GetCurrentHourTemperatureUseCase
    @Inject
    constructor(
        private val weatherRepository: WeatherGateway,
    ) {
        public operator fun invoke(): Flow<Result<Float>> =
            weatherRepository.hourly.map { hourly ->
                hourly.map { it.temperature }
            }
    }
