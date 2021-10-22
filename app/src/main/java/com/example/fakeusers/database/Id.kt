package com.example.fakeusers.database

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Id (
    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("value")
    @Expose
    var value: Any? = null
)