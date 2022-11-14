package com.example.circleever.NoticeSection

sealed class NoticeBoardScreens(val route: String){
    object NoticeBoard : NoticeBoardScreens("SocietyList")
    object NoticeBoardLogin: NoticeBoardScreens("NoticeBoardLogin")
    object AddNoticeWindow: NoticeBoardScreens("AddNoticeWindow")
}
