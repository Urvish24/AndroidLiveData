package com.hexagon.testapplication.oldpackage.pojo


import com.google.gson.annotations.SerializedName

data class Airlines(
    @SerializedName("data")
    val `data`: List<DataX>?,
    @SerializedName("totalPages")
    val totalPages: Int?,
    @SerializedName("totalPassengers")
    val totalPassengers: Int?
)