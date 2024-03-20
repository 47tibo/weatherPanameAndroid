package com.tibo47.weatherPaname

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import androidx.test.core.app.ActivityScenario
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit

@HiltAndroidTest
class MainActivityTest {
    private val server = MockWebServer()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createEmptyComposeRule()

    @Before
    fun setUp() {
        // mock network
        val body = ResourceReader.readText("OpenWeather_response200.json")
        server.enqueue(MockResponse().setBody(body).setBodyDelay(50L, TimeUnit.MILLISECONDS).setResponseCode(200))
        server.start(8080)

        // mock Clock.System::todayIn
        val todayInJson =
            Instant.fromEpochSeconds(1704204000).toLocalDateTime(
                TimeZone.currentSystemDefault(),
            ).date
        mockkStatic(Clock.System::todayIn)
        every { Clock.System.todayIn(TimeZone.currentSystemDefault()) } returns todayInJson
    }

    @After
    fun tearDown() {
        server.shutdown()
        unmockkAll()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun application_starts_displays_loader_then_displays_scrollable_hour_list() {
        ActivityScenario.launch(MainActivity::class.java)

        composeTestRule.waitUntilDoesNotExist(hasText("Loading", true))

        val hourList = composeTestRule.onNodeWithTag("HourList")

        hourList.onChildren().onFirst()
            .assert(hasText("15:00"))

        hourList.performScrollToNode(hasText("23:00"))
    }
}
