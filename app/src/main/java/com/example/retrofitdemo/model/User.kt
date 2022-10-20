package com.example.retrofitdemo.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("login")val login: String,
    @SerializedName("name") val name: String?,
    @SerializedName("bio")val bio: String?,
    @SerializedName("followers") val followers:Int?,
    @SerializedName("following") val following:Int?,
) : Serializable{

}