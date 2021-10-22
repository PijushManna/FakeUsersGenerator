package com.example.fakeusers.database

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Info (
    @SerializedName("seed")
    @Expose
    var seed: String? = null,

    @SerializedName("results")
    @Expose
    var results: Int? = null,

    @SerializedName("page")
    @Expose
    var page: Int? = null,

    @SerializedName("version")
    @Expose
    var version: String? = null
)