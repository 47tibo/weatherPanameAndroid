package com.tibo47.weatherPaname.weeklyWeatherUi.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage

@Composable
internal fun SunPosition() {
    val context = LocalContext.current
    val id =
        context.resources.getIdentifier(
            "_0",
            "drawable",
            context.packageName,
        )

    AsyncImage(model = id, contentDescription = null)
}
