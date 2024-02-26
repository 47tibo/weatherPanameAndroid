package com.tibo47.weatherPaname.hilt.dispatcher

import javax.inject.Qualifier

internal enum class DispatcherQualifier {
    Default,
    IO,
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
internal annotation class Dispatcher(val dispatcherQualifier: DispatcherQualifier)
