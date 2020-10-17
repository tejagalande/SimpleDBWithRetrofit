package com.example.demodatabasephp.service

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    var name : String?,

    @SerializedName("email")
    var email : String?,

    @SerializedName("username")
    var username : String?,

    @SerializedName("password")
    var password : String?
)