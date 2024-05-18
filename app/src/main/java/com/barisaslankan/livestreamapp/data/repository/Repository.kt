package com.barisaslankan.livestreamapp.data.repository

import com.barisaslankan.livestreamapp.domain.model.Webcam
import com.barisaslankan.livestreamapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getWebcams(): Flow<Resource<List<Webcam>>>
}