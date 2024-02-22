package com.tibo47.weatherPaname

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ActivityScenario
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
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
        val body = ResourceReader.readText("OpenWeather_response200.json")
        server.enqueue(MockResponse().setBody(body).setBodyDelay(1000L, TimeUnit.MILLISECONDS).setResponseCode(200))
        server.start(8080)
    }

    @After
    fun tearDown() = server.shutdown()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun test_temperature_displayed() {
        ActivityScenario.launch(MainActivity::class.java)
        composeTestRule.waitUntilDoesNotExist(hasText("Loading", true))
        composeTestRule.onNodeWithText("Current temp in Paris is : 1515", true).assertIsDisplayed()
    }
}
