package com.barisaslankan.livestreamapp.domain.model

import android.location.Location

data class Webcam(
    val title: String,
    val location: String,
    val liveStreamUrl: String,
    val lastUpdatedOn: String,
    val viewCount: Int
)