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


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * 
 *
 * @param dt 
 * @param precipitation 
 */
@Serializable

public data class OneCall200ResponseMinutelyInnerDto (

    @SerialName(value = "dt")
    val dt: kotlin.Float? = null,

    @SerialName(value = "precipitation")
    val precipitation: kotlin.Float? = null

)

