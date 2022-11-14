package com.example.circleever.data

data class Notices(
    val societyName: String,
    val noticeId: String,
    val noticeTitle: String,
    val noticeDetails: String,
    val noticeURL: String,
) {
    constructor() : this("", "", "", "", "")
}
