package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var username: String,
    var name: String,
    var location: String,
    var company: String,
    var repository: String,
    var followers: String,
    var following: String,
    var img: Int
) : Parcelable
