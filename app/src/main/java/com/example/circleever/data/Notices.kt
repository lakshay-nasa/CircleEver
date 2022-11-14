package com.example.circleever.data

import com.google.firebase.Timestamp

data class Notices(
    val societyName: String = "",
    val noticeId: String = "",
    val noticeTitle: String = "",
    val noticeDetails: String = "",
    val noticeURL: String = "",  //for image poster
    val timestamp: Timestamp = Timestamp.now(),
) {
    constructor() : this("", "", "", "", "")
}
