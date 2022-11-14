package com.example.circleever.NoticeSection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NoticeViewModel(val noticeRepository: NoticeRepository): ViewModel() {

    val noticeStateFlow = MutableStateFlow<NoticeResponse?>(null)

    init {
        viewModelScope.launch{
            noticeRepository.getNotices().collect{
                noticeStateFlow.value = it
            }
        }
    }

    fun getNotices() = noticeRepository.getNotices()
}