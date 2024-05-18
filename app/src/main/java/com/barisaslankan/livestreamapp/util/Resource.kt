package com.barisaslankan.livestreamapp.util

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val error: Exception) : Resource<Nothing>()
}
