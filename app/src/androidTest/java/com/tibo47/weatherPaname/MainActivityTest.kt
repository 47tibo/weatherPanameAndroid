package com.tibo47.weatherPaname

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createEmptyComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ActivityScenario
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createEmptyComposeRule()

    @Test
    fun test_temperature_displayed() {
        ActivityScenario.launch(MainActivity::class.java)
        composeTestRule.onNodeWithText("foo").assertIsDisplayed()
    }
}
