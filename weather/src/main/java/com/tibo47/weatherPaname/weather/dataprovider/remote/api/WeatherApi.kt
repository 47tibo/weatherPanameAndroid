package com.tibo47.weatherPaname.weather.dataprovider.remote.api

import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.tibo47.weatherPaname.weather.dataprovider.remote.dto.OneCall200ResponseDto

public interface WeatherApi {
    /**
     * one call
     * one call
     * Responses:
     *  - 200: one call
     *
     * @param lat  (optional)
     * @param lon  (optional)
     * @param appid  (optional)
     * @param units  (optional)
     * @return [OneCall200ResponseDto]
     */
    @GET("data/2.5/onecall")
    public suspend fun oneCall(@Query("lat") lat: kotlin.String? = null, @Query("lon") lon: kotlin.String? = null, @Query("appid") appid: kotlin.String? = null, @Query("units") units: kotlin.String? = null): Response<OneCall200ResponseDto>

}
