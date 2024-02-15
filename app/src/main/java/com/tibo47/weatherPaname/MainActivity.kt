package com.tibo47.weatherPaname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.tibo47.weatherPaname.ui.theme.WeatherPanameTheme
import com.tibo47.weatherPaname.weather.usecase.GetCurrentHourTemperatureUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var getCurrentHourTemperatureUseCase: GetCurrentHourTemperatureUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val stateFlow: StateFlow<String> =
            getCurrentHourTemperatureUseCase()
                .map { result ->
                    result.fold(
                        onSuccess = { it.toString() },
                        onFailure = { "error somewhere : $it" },
                    )
                }
                .stateIn(lifecycleScope, WhileSubscribed(5_000), "Loading...")

        setContent {
            WeatherPanameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    DisplayTemperature(stateFlow)
                }
            }
        }
    }
}

@Composable
fun DisplayTemperature(state: StateFlow<String>) {
    val temperature: String by state.collectAsStateWithLifecycle()
/*    Text(
        text = "Current temp in Paris is : $temperature",
    )*/
    Text(
        text = "foo",
    )
}
