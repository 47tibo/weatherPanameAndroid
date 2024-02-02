package com.tibo47.weatherPaname.weather.dataprovider.remote.api

import com.tibo47.weatherPaname.weather.BuildConfig
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitDataSourceModule {
    @Provides
    @Singleton
    internal fun providesApi(): WeatherApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
                )
                .build()
            )
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(WeatherApi::class.java)
    }
}
