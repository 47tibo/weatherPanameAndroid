package com.tibo47.weatherPaname.dailyWeatherUi.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tibo47.weatherPaname.dailyWeatherUi.ui.DailyWeatherScreen
import com.tibo47.weatherPaname.dailyWeatherUi.ui.DailyWeatherViewModel

public const val DAILY_WEATHER_ROUTE: String = "daily-weather"

public fun NavGraphBuilder.dailyWeatherScreen() {
    composable(DAILY_WEATHER_ROUTE) {
        val viewModel: DailyWeatherViewModel = hiltViewModel()
        val temperature by viewModel.temperatureStateFlow.collectAsStateWithLifecycle()
        DailyWeatherScreen(temperature)
    }
}
