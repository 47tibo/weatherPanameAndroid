package com.tibo47.weatherPaname.weeklyWeatherUi.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tibo47.weatherPaname.weeklyWeatherUi.ui.WeeklyWeatherRoute

public const val WEEKLY_WEATHER_ROUTE: String = "weekly-weather"

public fun NavGraphBuilder.weeklyWeatherScreen() {
    composable(WEEKLY_WEATHER_ROUTE) {
        WeeklyWeatherRoute()
    }
}
