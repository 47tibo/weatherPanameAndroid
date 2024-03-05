package com.tibo47.weatherPaname.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tibo47.weatherPaname.weeklyWeatherUi.navigation.WEEKLY_WEATHER_ROUTE
import com.tibo47.weatherPaname.weeklyWeatherUi.navigation.weeklyWeatherScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WEEKLY_WEATHER_ROUTE) {
        weeklyWeatherScreen()
    }
}
