package com.tibo47.weatherPaname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.tibo47.weatherPaname.ui.theme.WeatherPanameTheme
import com.tibo47.weatherPaname.weather.usecase.GetCurrentHourTemperatureUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var getCurrentHourTemperatureUseCase: GetCurrentHourTemperatureUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       getCurrentHourTemperatureUseCase()
           .onEach { result ->
               result.onSuccess { println(it) }
           }
           .launchIn(lifecycleScope)

            setContent {
                WeatherPanameTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Greeting("foo")
                    }
                }
            }

    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
    )
}
