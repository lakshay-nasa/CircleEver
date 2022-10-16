package com.example.circleever.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Society(
    val id : Int,
    val title : String,
    val description : String,
    val societyImageId : Int = 0,
    val about : String,
    val facilitators: Array<String>,
    val contact: Array<String>,
    val societySocialLinks: Array<String>,

): Parcelable

