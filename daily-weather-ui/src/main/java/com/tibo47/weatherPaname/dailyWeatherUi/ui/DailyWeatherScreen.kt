package com.tibo47.weatherPaname.dailyWeatherUi.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun DailyWeatherScreen(temperature: String) {
    Column {
        Text(
            text = "Current temp in Paris is : $temperature",
        )
        SunPosition()
    }
}
