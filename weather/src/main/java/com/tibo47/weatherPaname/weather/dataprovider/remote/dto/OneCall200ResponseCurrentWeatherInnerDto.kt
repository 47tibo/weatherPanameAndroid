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
 * @param description 
 * @param icon 
 * @param id 
 * @param main 
 */
@Serializable

internal data class OneCall200ResponseCurrentWeatherInnerDto (

    @SerialName(value = "description")
    val description: kotlin.String? = null,

    @SerialName(value = "icon")
    val icon: kotlin.String? = null,

    @Contextual @SerialName(value = "id")
    val id: java.math.BigDecimal? = null,

    @SerialName(value = "main")
    val main: kotlin.String? = null

)

