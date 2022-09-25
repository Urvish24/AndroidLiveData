package com.hexagon.testapplication.oldpackage.pojo


import com.google.gson.annotations.SerializedName

data class ContactDetails(
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("dial_code")
    val dialCode: String?,
    @SerializedName("mobile_number")
    val mobileNumber: String?
)