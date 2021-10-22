package com.example.fakeusers.database

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Location (
    @SerializedName("street")
    @Expose
    var street: Street? = null,

    @SerializedName("city")
    @Expose
    var city: String? = null,

    @SerializedName("state")
    @Expose
    var state: String? = null,

    @SerializedName("country")
    @Expose
    var country: String? = null,

    @SerializedName("postcode")
    @Expose
    var postcode: String? = null,

    @SerializedName("coordinates")
    @Expose
    var coordinates: Coordinates? = null,

    @SerializedName("timezone")
    @Expose
    var timezone: Timezone? = null
)