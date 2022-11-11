package com.example.circleever.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//@Parcelize
data class Societies(
    val title: String,
    val about: String,
) {
    constructor() : this("", "")
}
