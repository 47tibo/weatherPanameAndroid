package com.tibo47.weatherPaname.weeklyWeatherUi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun WeeklyWeatherScreen(uiState: WeeklyWeatherUiState.Success) {
    Column {
        Text(
            text = "current hourly weather available instant is : ${uiState.hours.first()}",
        )
    }
}
