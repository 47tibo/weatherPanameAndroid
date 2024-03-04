package com.tibo47.weatherPaname.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tibo47.weatherPaname.dailyWeatherUi.navigation.DAILY_WEATHER_ROUTE
import com.tibo47.weatherPaname.dailyWeatherUi.navigation.dailyWeatherScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DAILY_WEATHER_ROUTE) {
        dailyWeatherScreen()
    }
}
