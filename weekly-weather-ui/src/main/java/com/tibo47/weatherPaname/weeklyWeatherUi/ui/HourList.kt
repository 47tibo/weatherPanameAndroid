package com.tibo47.weatherPaname.weeklyWeatherUi.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.tibo47.weatherPaname.extension.formatToRoundedTwentyFourHours
import kotlinx.datetime.Instant

@Composable
internal fun HourList(hours: List<Instant>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.testTag("HourList"),
    ) {
        items(hours) { hour ->
            Row(
                modifier = Modifier.padding(16.dp),
            ) {
                Text(text = hour.formatToRoundedTwentyFourHours())
            }
        }
    }
}
