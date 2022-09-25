package com.hexagon.testapplication.oldpackage.pojo


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("airline")
    val airline: List<Airline?>?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("trips")
    val trips: Int?,
    @SerializedName("__v")
    val v: Int?
)