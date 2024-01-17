package com.tibo47.weatherPaname.weather.usecase

import javax.inject.Inject

 public class GetCurrentHourTemperatureUseCase @Inject constructor() {
    public operator fun invoke(): Unit = println("weather from Paris")
}
