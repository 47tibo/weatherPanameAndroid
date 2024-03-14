package com.tibo47.weatherPaname.weeklyWeatherUi.ui

import kotlinx.datetime.Instant

internal sealed interface WeeklyWeatherUiState {
    data object Loading : WeeklyWeatherUiState

    data object Failure : WeeklyWeatherUiState

    data class Success(
        val hours: List<Instant>,
    ) : WeeklyWeatherUiState
}
