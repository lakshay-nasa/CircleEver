package com.example.circleever.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Societies(
    val name: String,
    val about: String,
): Parcelable {
    constructor() : this("", "")
}
