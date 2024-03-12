/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.tibo47.weatherPaname.weather.dataprovider.remote.dto

import com.tibo47.weatherPaname.weather.dataprovider.remote.dto.OneCall200ResponseCurrentRainDto
import com.tibo47.weatherPaname.weather.dataprovider.remote.dto.OneCall200ResponseCurrentWeatherInnerDto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * 
 *
 * @param clouds 
 * @param dewPoint 
 * @param dt 
 * @param feelsLike 
 * @param humidity 
 * @param pressure 
 * @param rain 
 * @param sunrise 
 * @param sunset 
 * @param temp 
 * @param uvi 
 * @param visibility 
 * @param weather 
 * @param windDeg 
 * @param windGust 
 * @param windSpeed 
 */
@Serializable

public data class OneCall200ResponseCurrentDto (

    @SerialName(value = "clouds")
    val clouds: kotlin.Float? = null,

    @SerialName(value = "dew_point")
    val dewPoint: kotlin.Float? = null,

    @SerialName(value = "dt")
    val dt: kotlin.Float? = null,

    @SerialName(value = "feels_like")
    val feelsLike: kotlin.Float? = null,

    @SerialName(value = "humidity")
    val humidity: kotlin.Float? = null,

    @SerialName(value = "pressure")
    val pressure: kotlin.Float? = null,

    @SerialName(value = "rain")
    val rain: OneCall200ResponseCurrentRainDto? = null,

    @SerialName(value = "sunrise")
    val sunrise: kotlin.Float? = null,

    @SerialName(value = "sunset")
    val sunset: kotlin.Float? = null,

    @SerialName(value = "temp")
    val temp: kotlin.Float? = null,

    @SerialName(value = "uvi")
    val uvi: kotlin.Float? = null,

    @SerialName(value = "visibility")
    val visibility: kotlin.Float? = null,

    @SerialName(value = "weather")
    val weather: kotlin.collections.List<OneCall200ResponseCurrentWeatherInnerDto>? = null,

    @SerialName(value = "wind_deg")
    val windDeg: kotlin.Float? = null,

    @SerialName(value = "wind_gust")
    val windGust: kotlin.Float? = null,

    @SerialName(value = "wind_speed")
    val windSpeed: kotlin.Float? = null

)

