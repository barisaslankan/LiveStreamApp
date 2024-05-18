package com.barisaslankan.livestreamapp.domain.repository

import com.barisaslankan.livestreamapp.data.remote.WindyApi
import com.barisaslankan.livestreamapp.data.remote.dto.mapWebcamDTOToWebcam
import com.barisaslankan.livestreamapp.data.repository.Repository
import com.barisaslankan.livestreamapp.domain.model.Webcam
import com.barisaslankan.livestreamapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(private val api: WindyApi) : Repository {
    override suspend fun getWebcams(): Flow<Resource<List<Webcam>>> = flow {
        try {
            val response = api.getWebcams()
            if (response.total > 0) {
                emit(Resource.Success(response.webcamDTOS.map { mapWebcamDTOToWebcam(it) }))
            } else {
                emit(Resource.Error(Exception("No webcam available")))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}