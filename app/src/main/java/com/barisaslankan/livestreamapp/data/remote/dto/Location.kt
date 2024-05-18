package com.barisaslankan.livestreamapp.data.remote.dto

data class Location(
    val city: String,
    val continent: String,
    val continent_code: String,
    val country: String,
    val country_code: String,
    val latitude: Double,
    val longitude: Double,
    val region: String,
    val region_code: String
)