package com.tibo47.weatherPaname.weather.usecase

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Instant
import javax.inject.Inject

/**
 * @return A list of hours (kotlin Instant) for whom weather in downtown Paris is available
 */
@ViewModelScoped
public class GetTodayHoursUseCase
    @Inject
    constructor(
        private val weatherRepository: WeatherGateway,
    ) {
        public operator fun invoke(): Flow<Result<List<Instant>>> =
            weatherRepository.hourlies.map { hourlies ->
                hourlies.map { hourly ->
                    hourly.map { it.timestamp }
                }
            }
    }
