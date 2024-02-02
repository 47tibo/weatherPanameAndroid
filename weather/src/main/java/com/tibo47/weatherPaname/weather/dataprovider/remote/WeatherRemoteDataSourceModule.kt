package com.tibo47.weatherPaname.weather.dataprovider.remote

import com.tibo47.weatherPaname.weather.dataprovider.remote.api.RetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class WeatherRemoteDataSourceModule {
    @Binds
    internal abstract fun bindsWeatherRemoteDataSource(dataSource: RetrofitDataSource): WeatherRemoteDataSource
}
