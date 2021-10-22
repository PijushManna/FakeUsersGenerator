package com.example.fakeusers.database

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Coordinates (
    @SerializedName("latitude")
    @Expose
    var latitude: String? = null,

    @SerializedName("longitude")
    @Expose
    var longitude: String? = null
)