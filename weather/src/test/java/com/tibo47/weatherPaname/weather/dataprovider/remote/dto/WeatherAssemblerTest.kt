package com.tibo47.weatherPaname.weather.dataprovider.remote.dto

import com.tibo47.weatherPaname.weather.entity.HourlyWeatherEntity
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

class WeatherAssemblerTest {
    private val todayFromEpochSeconds = 1578915200F
    private val otherDayFromEpochSeconds = 1678915200F

    private val assembler = WeatherAssembler()

    private fun mockClockSystemTodayIn() {
        val today =
            Instant.fromEpochSeconds(todayFromEpochSeconds.toLong()).toLocalDateTime(
                TimeZone.currentSystemDefault(),
            ).date
        mockkStatic(Clock.System::todayIn)
        every { Clock.System.todayIn(TimeZone.currentSystemDefault()) } returns today
    }

    @Before
    fun setUp() {
        mockClockSystemTodayIn()
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `createHourlies returns list of hourlies for today and removes hourlies for other days`() {
        val dto =
            OneCall200ResponseDto(
                hourly =
                    listOf(
                        OneCall200ResponseHourlyInnerDto(
                            dt = todayFromEpochSeconds,
                            temp = 20.0F,
                            windSpeed = 5.0F,
                            windDeg = 180F,
                        ),
                        OneCall200ResponseHourlyInnerDto(
                            dt = otherDayFromEpochSeconds,
                            temp = 18.0F,
                            windSpeed = 4.0F,
                            windDeg = 150F,
                        ),
                    ),
            )

        val expectedHourlies =
            listOf(
                HourlyWeatherEntity(
                    temperature = 20.0F,
                    timestamp = Instant.fromEpochSeconds(todayFromEpochSeconds.toLong()),
                    windSpeed = 5.0F,
                    windDirection = 180F,
                ),
            )

        val actualHourlies = assembler.createHourlies(dto)

        assertEquals(expectedHourlies, actualHourlies)
    }

    @Test
    fun`createHourlies throws exception if input dto is null`() {
        assertThrows(Exception::class.java) {
            assembler.createHourlies(null)
        }
    }
}
