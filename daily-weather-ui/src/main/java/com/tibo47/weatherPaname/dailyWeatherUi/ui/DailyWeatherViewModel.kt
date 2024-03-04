package com.tibo47.weatherPaname.dailyWeatherUi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tibo47.weatherPaname.weather.usecase.GetCurrentHourTemperatureUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class DailyWeatherViewModel
    @Inject
    constructor(
        private val getCurrentHourTemperatureUseCase: GetCurrentHourTemperatureUseCase,
    ) : ViewModel() {
        val temperatureStateFlow =
            getCurrentHourTemperatureUseCase().map { result ->
                result.fold(
                    onSuccess = { it.toString() },
                    onFailure = { "error when accessing temp : ${it.message}" },
                )
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(2_000, 0), "Loading...")
    }
