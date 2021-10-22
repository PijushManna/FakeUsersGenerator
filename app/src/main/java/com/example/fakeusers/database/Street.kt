package com.example.fakeusers.database

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Street (
    @SerializedName("number")
    @Expose
    var number: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
)