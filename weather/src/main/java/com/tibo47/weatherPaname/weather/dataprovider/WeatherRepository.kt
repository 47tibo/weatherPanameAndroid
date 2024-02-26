package com.tibo47.weatherPaname.weather.dataprovider

import com.tibo47.weatherPaname.hilt.dispatcher.Dispatcher
import com.tibo47.weatherPaname.hilt.dispatcher.DispatcherQualifier
import com.tibo47.weatherPaname.weather.dataprovider.remote.WeatherRemoteDataSource
import com.tibo47.weatherPaname.weather.entity.HourlyWeather
import com.tibo47.weatherPaname.weather.usecase.WeatherGateway
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class WeatherRepository
    @Inject
    constructor(
        private val remoteDataSource: WeatherRemoteDataSource,
        @Dispatcher(DispatcherQualifier.IO) private val dispatcher: CoroutineDispatcher,
    ) : WeatherGateway {
        override val hourly: Flow<Result<HourlyWeather>> =
            flow {
                emit(remoteDataSource.fetchHourlyWeather())
            }.flowOn(dispatcher)
    }
