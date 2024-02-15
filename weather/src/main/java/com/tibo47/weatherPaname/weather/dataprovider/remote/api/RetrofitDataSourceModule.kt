package com.tibo47.weatherPaname.weather.dataprovider.remote.api

import com.tibo47.httpClient.RetrofitBuilder
import com.tibo47.weatherPaname.weather.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitDataSourceModule {
    @Provides
    @Singleton
    internal fun providesWeatherApi(
        @RetrofitBuilder builder: Retrofit.Builder,
    ): WeatherApi =
        builder
            .baseUrl(BuildConfig.BASE_URL)
            .build().create(WeatherApi::class.java)
}
