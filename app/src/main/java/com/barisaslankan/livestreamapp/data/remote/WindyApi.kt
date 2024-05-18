package com.barisaslankan.livestreamapp.data.remote

import com.barisaslankan.livestreamapp.data.remote.dto.WebcamsDTO
import retrofit2.http.GET
import retrofit2.http.Header

interface WindyApi {
    @GET("/webcams")
    suspend fun getWebcams(
        @Header("x-windy-api-key") apiKey: String = System.getProperty("WINDY_API_KEY") ?: ""
    ): WebcamsDTO
}