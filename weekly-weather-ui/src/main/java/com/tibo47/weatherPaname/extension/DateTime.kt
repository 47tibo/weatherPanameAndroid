package com.tibo47.weatherPaname.extension

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal fun Instant.formatToRoundedTwentyFourHours(): String {
    val tzParis = TimeZone.of("Europe/Paris")
    val localDateTime = toLocalDateTime(tzParis)
    val time = localDateTime.time
    val hour = time.hour + if (time.minute > 30) 1 else 0
    return "$hour:00"
}
