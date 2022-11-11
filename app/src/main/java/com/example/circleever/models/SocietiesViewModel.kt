package com.example.circleever.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.circleever.SocietiesResponse
import com.example.circleever.repo.SocietiesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class SocietiesViewModel(val societiesRepository: SocietiesRepository): ViewModel() {

    val societiesStateFlow = MutableStateFlow<SocietiesResponse?>(null)

    init {
        viewModelScope.launch {
            societiesRepository.getSocietiesDetails().collect {
                societiesStateFlow.value = it
            }
        }
    }

    fun getSocietiesInfo() = societiesRepository.getSocietiesDetails()
}