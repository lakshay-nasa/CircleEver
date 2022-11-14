package com.example.circleever.NoticeSection

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.circleever.data.Notices
import com.google.firebase.Timestamp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NoticeViewModel(private val noticeRepository: NoticeRepository = NoticeRepository()): ViewModel() {


    var noticeUiState by mutableStateOf(NoticeUiState())
        private set

    val noticeStateFlow = MutableStateFlow<NoticeResponse?>(null)

    fun onSocietyNameChange(societyName: String) {
        noticeUiState = noticeUiState.copy(societyName = societyName)
    }

    fun onTitleChange(noticeTitle: String) {
        noticeUiState = noticeUiState.copy(noticeTitle = noticeTitle)
    }

    fun onNoticeChange(noticeDetails: String) {
        noticeUiState = noticeUiState.copy(noticeDetails = noticeDetails)
    }

    fun onURLChange(noticeURL: String) {
        noticeUiState = noticeUiState.copy(noticeURL = noticeURL)
    }

    fun addNotice(noticeId: String) {
        if (true) {
            noticeRepository.addNotice(
                noticeId = noticeId,
                societyName = noticeUiState.societyName,
                noticeTitle = noticeUiState.noticeTitle,
                noticeDetails = noticeUiState.noticeDetails,
                noticeURL = noticeUiState.noticeURL,
                timestamp = Timestamp.now()
            ) {
                noticeUiState = noticeUiState.copy(noticeAddedStatus = it)
            }
        }
    }


    fun setEditFields(notice: Notices){
        noticeUiState = noticeUiState.copy(
            noticeTitle = notice.noticeTitle,
            noticeDetails = notice.noticeDetails
        )
    }


    fun getNotice(noticeId:String){
        noticeRepository.getNotice(
            noticeId = noticeId,
            onError = {},
        ){
            noticeUiState = noticeUiState.copy(selectedNotice = it)
            noticeUiState.selectedNotice?.let { it1 -> setEditFields(it1) }
        }
    }

    fun updateNotice(
        noticeId: String
    ){
        noticeRepository.updateNotice(
            noticeTitle = noticeUiState.noticeTitle,
            noticeDetails = noticeUiState.noticeDetails,
            noticeId = noticeId,
        ){
            noticeUiState = noticeUiState.copy(updateNoticeStatus = it)
        }
    }


    fun resetNoticeAddedStatus(){
        noticeUiState = noticeUiState.copy(
            noticeAddedStatus = false,
            updateNoticeStatus = false,
        )
    }

    fun resetState(){
        noticeUiState = NoticeUiState()
    }



    ///--->>

    init {
        viewModelScope.launch{
            noticeRepository.getNotices().collect{
                noticeStateFlow.value = it
            }
        }
    }

    fun getNotices() = noticeRepository.getNotices()

    ///--->>

}



data class NoticeUiState(
    val societyName: String = "",
    val noticeTitle: String = "",
    val noticeDetails: String = "",
    val noticeURL: String = "",
    val noticeAddedStatus: Boolean = false,
    val updateNoticeStatus: Boolean = false,
    val selectedNotice: Notices? = null,
)