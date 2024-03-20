package com.tibo47.weatherPaname.extension

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import org.junit.Assert.assertEquals
import org.junit.Test

class DateTimeTest {
    @Test
    fun `formats Instant to the closest lowest hour in a twenty four hour display with hour semi colon and zero minutes`() {
        val instant = LocalDateTime(2024, 2, 17, 12, 3, 45).toInstant(TimeZone.currentSystemDefault())
        assertEquals("12:00", instant.formatToRoundedTwentyFourHours())
    }

    @Test
    fun `formats Instant to the closest highest hour in a twenty four hour display with hour semi colon and zero minutes`() {
        val instant = LocalDateTime(2024, 2, 17, 12, 43, 23).toInstant(TimeZone.currentSystemDefault())
        assertEquals("13:00", instant.formatToRoundedTwentyFourHours())
    }
}
