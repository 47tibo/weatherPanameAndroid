package com.tibo47.weatherPaname.hilt.dispatcher

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
internal object DispatcherModule {
    @Dispatcher(DispatcherQualifier.Default)
    @Provides
    fun providesDispatcherDefault(): CoroutineDispatcher = Dispatchers.Default

    @Dispatcher(DispatcherQualifier.IO)
    @Provides
    fun providesDispatcherIO(): CoroutineDispatcher = Dispatchers.IO
}
