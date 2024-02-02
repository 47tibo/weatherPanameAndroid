package com.tibo47.weatherPaname.weather.dataprovider

import com.tibo47.weatherPaname.weather.usecase.WeatherGateway
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class WeatherDataProviderModule {
    @Binds
    internal abstract fun bindsWeatherGateway(repository: WeatherRepository): WeatherGateway
}
