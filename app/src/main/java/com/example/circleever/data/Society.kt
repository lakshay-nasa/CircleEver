package com.example.circleever.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Society(
    val id : Int,
    val title : String,
    val description : String,
    val societyImageId : Int,
    val about : String,
    val facilitator1: String,
    val facilitator2: String,
    val contact1: String,
    val contact2: String,
    val InstagramLink: String,
    val LinkedInLink: String,

): Parcelable

