package com.example.fakeusers.database

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FakeUser(
    @SerializedName("results")
    @Expose
    var results: List<Result>? = null,

    @SerializedName("info")
    @Expose
    var info: Info? = null
)