package com.tibo47.weatherPaname.dailyWeatherUi.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tibo47.weatherPaname.dailyWeatherUi.ui.DailyWeatherScreen

public const val DAILY_WEATHER_ROUTE: String = "daily-weather"

public fun NavGraphBuilder.dailyWeatherScreen() {
    composable(DAILY_WEATHER_ROUTE) {
        DailyWeatherScreen(temperature = "1515.0")
    }
}
