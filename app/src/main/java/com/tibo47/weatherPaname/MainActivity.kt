package com.tibo47.weatherPaname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tibo47.androidPlatform.theme.MainTheme
import com.tibo47.weatherPaname.ui.MainApplicationScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainTheme {
                MainApplicationScreen()
            }
        }
    }
}
