package com.example.circleever.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
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
) : Parcelable {
    constructor(
        title: String,
        about: String,
        tagLine: String,
        achievement0: String,
        achievement1: String,
        achievement2: String,
        achievement3: String,
        achievement4: String,
        coordinator1: String,
        coordinator2: String,
        coordinatorDetails1: String,
        coordinatorDetails2: String,
        SocialLink1: String,
        SocialLink2: String,
        SocialLink3: String,
        SocialLink4: String, ) : this("", "", "", "", "", "", "", "", "","","","","","","","","","")
}
