package com.example.first_app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Spots(var cardImage: Int, var cardTitle: String, var cardBody: String, var cardDistance: String) :
    Parcelable
