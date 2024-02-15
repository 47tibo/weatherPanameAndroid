package com.tibo47.httpClient

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RetrofitBuilder

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MockedRetrofitBuilder

@Module
@InstallIn(SingletonComponent::class)
public object HttpClientModule {
    @RetrofitBuilder
    @Provides
    public fun providesRetrofitBuilder(): Retrofit.Builder =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC),
                    )
                    .build(),
            )
}
