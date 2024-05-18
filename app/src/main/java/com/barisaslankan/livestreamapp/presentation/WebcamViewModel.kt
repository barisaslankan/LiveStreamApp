package com.barisaslankan.livestreamapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barisaslankan.livestreamapp.data.repository.Repository
import com.barisaslankan.livestreamapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WebcamViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _webcamsState = MutableStateFlow(WebcamsState())
    val webcamsState = _webcamsState.asStateFlow()

    init {
        getWebcams()
    }

    private fun getWebcams() {
        viewModelScope.launch {
            _webcamsState.value = _webcamsState.value.copy(isLoading = true)
            repository.getWebcams().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _webcamsState.value = WebcamsState(webcams = result.data)
                    }
                    is Resource.Error -> {
                        _webcamsState.value = WebcamsState(error = result.error.message)
                    }
                }
            }
            _webcamsState.value = _webcamsState.value.copy(isLoading = false)
        }
    }
}