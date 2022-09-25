package com.hexagon.testapplication.oldpackage.pojo


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("address")
    val address: String?,
    @SerializedName("approved_status")
    val approvedStatus: Int?,
    @SerializedName("company")
    val company: String?,
    @SerializedName("contact_details")
    val contactDetails: ContactDetails?,
    @SerializedName("created_at")
    val createdAt: Int?,
    @SerializedName("created_by")
    val createdBy: String?,
    @SerializedName("deleted_at")
    val deletedAt: Any?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("_id")
    val id: String?,
    @SerializedName("last_name")
    val lastName: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("profile_image")
    val profileImage: String?,
    @SerializedName("refresh_tokens")
    val refreshTokens: String?,
    @SerializedName("reset_password_token")
    val resetPasswordToken: Any?,
    @SerializedName("status")
    val status: Int?,
    @SerializedName("updated_at")
    val updatedAt: Int?,
    @SerializedName("user_type")
    val userType: Int?,
    @SerializedName("__v")
    val v: Int?
)