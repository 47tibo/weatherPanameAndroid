package com.tibo47.weatherPaname.ui

import androidx.compose.runtime.Composable
import com.tibo47.weatherPaname.dailyWeatherUi.ui.DailyWeatherScreen

@Composable
fun MainApplicationScreen(temperature: String) {
    DailyWeatherScreen(temperature)
}
