package com.tibo47.weatherPaname.weeklyWeatherUi.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tibo47.weatherPaname.weeklyWeatherUi.ui.WeeklyWeatherScreen
import com.tibo47.weatherPaname.weeklyWeatherUi.ui.WeeklyWeatherUiState
import com.tibo47.weatherPaname.weeklyWeatherUi.ui.WeeklyWeatherViewModel

public const val WEEKLY_WEATHER_ROUTE: String = "weekly-weather"

public fun NavGraphBuilder.weeklyWeatherScreen() {
    composable(WEEKLY_WEATHER_ROUTE) {
        val viewModel: WeeklyWeatherViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        when (uiState) {
            WeeklyWeatherUiState.Failure -> Text(text = "Failure somewhere")
            WeeklyWeatherUiState.Loading -> Text(text = "Loading")
            is WeeklyWeatherUiState.Success -> WeeklyWeatherScreen(uiState as WeeklyWeatherUiState.Success)
        }
    }
}
