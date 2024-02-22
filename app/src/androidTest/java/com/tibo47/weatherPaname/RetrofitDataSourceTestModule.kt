package com.tibo47.weatherPaname

import com.tibo47.weatherPaname.weather.dataprovider.remote.api.RetrofitDataSourceModule
import com.tibo47.weatherPaname.weather.dataprovider.remote.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import retrofit2.Retrofit

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RetrofitDataSourceModule::class],
)
internal object RetrofitDataSourceTestModule {
    @Provides
    fun providesWeatherApi(builder: Retrofit.Builder): WeatherApi =
        builder.baseUrl("http://localhost:8080/").build().create(WeatherApi::class.java)
}
