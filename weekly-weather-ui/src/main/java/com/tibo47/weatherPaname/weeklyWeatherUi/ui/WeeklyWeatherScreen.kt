package com.tibo47.weatherPaname.weeklyWeatherUi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun WeeklyWeatherRoute(
    modifier: Modifier = Modifier,
    viewModel: WeeklyWeatherViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (uiState) {
        WeeklyWeatherUiState.Failure -> Text(text = "Failure somewhere")
        WeeklyWeatherUiState.Loading -> Text(text = "Loading")
        is WeeklyWeatherUiState.Success -> WeeklyWeatherScreen(uiState = uiState as WeeklyWeatherUiState.Success)
    }
}

@Composable
internal fun WeeklyWeatherScreen(uiState: WeeklyWeatherUiState.Success) {
    Column {
        HourList(hours = uiState.hours)
    }
}
