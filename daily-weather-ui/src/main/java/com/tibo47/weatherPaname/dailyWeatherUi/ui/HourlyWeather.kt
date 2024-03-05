package com.tibo47.weatherPaname.dailyWeatherUi.ui

import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import com.tibo47.weatherPaname.dailyWeatherUi.R


@Composable
public fun SunPosition() {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(
        "_0",
        "drawable",
        context.packageName
    )


    AsyncImage(model = id, contentDescription = null)
}
