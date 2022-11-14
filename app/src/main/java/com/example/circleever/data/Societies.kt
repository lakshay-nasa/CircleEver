package com.example.circleever.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//@Parcelize
data class Societies(
    val title: String,
    val about: String,
    val tagLine: String,
    val achievement0: String,
    val achievement1: String,
    val achievement2: String,
    val achievement3: String,
    val achievement4: String,
    val logoURL: String,
    val contactDetails: String,
    val coordinator1: String,
    val coordinatorDetails1: String,
    val coordinator2: String,
    val coordinatorDetails2: String,
    val socialLink1: String,
    val socialLink2: String,
    val socialLink3: String,
    val socialLink4: String,





) {
    constructor() : this("", "", "", "", "", "", "", "", "","","","","","","","","","")
}
