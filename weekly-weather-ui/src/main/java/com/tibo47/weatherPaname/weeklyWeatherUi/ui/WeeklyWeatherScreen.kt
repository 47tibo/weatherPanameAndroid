package com.tibo47.weatherPaname.weeklyWeatherUi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
internal fun WeeklyWeatherScreen(uiState: WeeklyWeatherUiState.Success) {
    Column {
        HourList(hours = uiState.hours)
    }
}
