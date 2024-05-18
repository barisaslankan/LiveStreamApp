package com.barisaslankan.livestreamapp.presentation

import com.barisaslankan.livestreamapp.domain.model.Webcam

data class WebcamsState(
    val isLoading: Boolean = false,
    val webcams: List<Webcam>? = null,
    val error: String? = null
)

